package com.codingmonster.marketmaker;

import com.codingmonster.common.sbe.*;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.logbuffer.FragmentHandler;
import io.aeron.logbuffer.Header;
import java.nio.ByteBuffer;
import org.agrona.DirectBuffer;
import org.agrona.concurrent.Agent;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;
import org.agrona.concurrent.YieldingIdleStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarketMakerAgent implements Agent {

  private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
  private final Aeron aeron;

  private final Publication publication;
  private final Subscription subscription;
  private final UnsafeBuffer sendBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));
  private final MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
  private final MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
  private final NewOrderMessageEncoder orderEncoder = new NewOrderMessageEncoder();
  private final NewOrderMessageDecoder orderMessageDecoder = new NewOrderMessageDecoder();
  private final IdleStrategy idleStrategy = new YieldingIdleStrategy();
  private final OrderIdGenerator idGenerator;

  public MarketMakerAgent(
      Aeron aeron,
      String pubChannel,
      int pubStreamId,
      String subChannel,
      int subStreamId,
      String idFilePath) {
    this.aeron = aeron;
    this.idGenerator = new OrderIdGenerator(idFilePath);
    this.publication = aeron.addPublication(pubChannel, pubStreamId);
    this.subscription = aeron.addSubscription(subChannel, subStreamId);
  }

  @Override
  public void onStart() {
    Agent.super.onStart();
  }

  public int doWork() {
    return subscription.poll(this::onFragment, 10);
  }

  private void onFragment(DirectBuffer buffer, int offset, int length, Header header) {
    headerDecoder.wrap(buffer, offset);
    final int templateId = headerDecoder.templateId();
    final int actingBlockLength = headerDecoder.blockLength();
    final int actingVersion = headerDecoder.version();
    final int messageOffset = offset + headerDecoder.encodedLength();

    switch (templateId) {
      case NewOrderMessageDecoder.TEMPLATE_ID:
        orderMessageDecoder.wrap(buffer, messageOffset, actingBlockLength, actingVersion);
        // Process new order
        break;

      default:
        // unknown
    }
  }

  private int handleNewOrder() {
    FragmentHandler handler = null;
    int count = subscription.poll(handler, 10);
    return 0;
  }

  private void sendNewOrderSingle(String symbol, Side side, double price, int qty) {
    // Reset buffer offset for reuse
    int offset = 0;

    // Encode header
    headerEncoder
        .wrap(sendBuffer, offset)
        .blockLength(NewOrderMessageEncoder.BLOCK_LENGTH)
        .templateId(NewOrderMessageEncoder.TEMPLATE_ID)
        .schemaId(NewOrderMessageEncoder.SCHEMA_ID)
        .version(NewOrderMessageEncoder.SCHEMA_VERSION);

    // Encode order
    orderEncoder
        .wrapAndApplyHeader(sendBuffer, offset, headerEncoder)
        .clientId(idGenerator.nextId()) // Unique ID
        .symbol(symbol)
        .side(Side.Buy)
        .quantity(qty);
    orderEncoder.price().mantissa(12345).exponent((byte) -3);

    // Publish with backpressure handling
    long result =
        publication.offer(
            sendBuffer, offset, headerEncoder.encodedLength() + orderEncoder.encodedLength());
    if (result < 0) {
      idleStrategy.idle(); // Handle backpressure
    }
  }

  @Override
  public void onClose() {
    Agent.super.onClose();
  }

  @Override
  public String roleName() {
    return "marketmaker";
  }
}
