package com.codingmonster.common;

//import com.codingmonster.common.sbe.*;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import io.aeron.logbuffer.FragmentHandler;

import java.math.BigDecimal;
import java.nio.ByteBuffer;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimplestCase {
  private static final Logger LOGGER = LoggerFactory.getLogger(SimplestCase.class);

  public static void main(final String[] args) {
    final String channel = "aeron:ipc";
    final IdleStrategy idle = new SleepingIdleStrategy();
    final UnsafeBuffer unsafeBuffer = new UnsafeBuffer(ByteBuffer.allocateDirect(256));
    Aeron.Context context = new Aeron.Context()
            .aeronDirectoryName("/tmp/aeron");

    try (// MediaDriver driver = MediaDriver.launch();
        Aeron aeron = Aeron.connect(context);
        Subscription sub = aeron.addSubscription(channel, 10);
        Publication pub = aeron.addPublication(channel, 10)) {
      while (!pub.isConnected()) {
        idle.idle();
      }

//      MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
//      TradeDataEncoder dataEncoder = new TradeDataEncoder();
//
//      TradeDataEncoder encoder = dataEncoder.wrapAndApplyHeader(unsafeBuffer, 0, headerEncoder);
//      BigDecimal price = BigDecimal.valueOf(344.45);
//      encoder.amount(5).quote().symbol("IBM").currency(Currency.USD).market(Market.NASDAQ).price()
//              .mantissa(price.scaleByPowerOfTen(price.scale()).intValue())
//              .exponent((byte) (price.scale() * -1));
//      LOGGER.info("sending...");
//      while (pub.offer(unsafeBuffer) < 0) {
//        idle.idle();
//      }
//
//      final FragmentHandler handler =
//          (buffer, offset, length, header) ->
//              LOGGER.info("received...");
//
//      while (sub.poll(handler, 1) <= 0) {
//        idle.idle();
//      }
//
//      MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
//      TradeDataDecoder dataDecoder = new TradeDataDecoder();
//      dataDecoder.wrapAndApplyHeader(unsafeBuffer, 0, headerDecoder);
//
//      double priceDbl = BigDecimal.valueOf(dataDecoder.quote().price().mantissa())
//              .scaleByPowerOfTen(dataDecoder.quote().price().exponent())
//              .doubleValue();
//
//      System.out.println("**********************");
//      System.out.println(priceDbl);
    }
  }
}
