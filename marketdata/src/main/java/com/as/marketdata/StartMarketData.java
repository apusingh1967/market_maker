package com.as.marketdata;

import com.as.common.codec.MessageHeaderEncoder;
import com.as.common.codec.QuoteEncoder;
import io.aeron.Aeron;
import io.aeron.Publication;
import io.aeron.Subscription;
import io.aeron.driver.MediaDriver;
import io.aeron.driver.ThreadingMode;
import io.aeron.logbuffer.FragmentHandler;
import java.nio.ByteBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.IdleStrategy;
import org.agrona.concurrent.SleepingIdleStrategy;
import org.agrona.concurrent.UnsafeBuffer;

public class StartMarketData {

  public void start() {
    MediaDriver.Context ctx =
        new MediaDriver.Context().dirDeleteOnStart(true).threadingMode(ThreadingMode.SHARED);

    try (MediaDriver driver = MediaDriver.launch()) {

      Thread t1 =
          Thread.startVirtualThread(
              () -> {
                send();
              });

      Thread t2 =
          Thread.startVirtualThread(
              () -> {
                receive();
              });

      t1.join();
      t2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  void send() {
    ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256);
    MutableDirectBuffer buffer = new UnsafeBuffer(byteBuffer);
    MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    QuoteEncoder quote = get(buffer, headerEncoder);

    final String channel = "aeron:ipc";
    final IdleStrategy idle = new SleepingIdleStrategy();

    try (Aeron aeron = Aeron.connect();
        Publication pub = aeron.addPublication(channel, 10)) {
      // Send the original buffer that already contains the encoded message
      System.out.println("Sending message of length: " + quote.encodedLength());

      // Offer the original buffer (not a copy)
      long result;
      while ((result = pub.offer(buffer, 0, headerEncoder.encodedLength() + quote.encodedLength()))
          < 0) {
        // Handle backpressure
        if (result == Publication.NOT_CONNECTED) {
          System.out.println("Not connected yet...");
        } else if (result == Publication.BACK_PRESSURED) {
          System.out.println("Back pressured...");
        }
        idle.idle();
      }

      System.out.println("Message sent successfully!");
    }
  }

  void receive() {
    //        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256);
    //        MutableDirectBuffer buffer = new UnsafeBuffer(byteBuffer);
    //        MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();

    final String channel = "aeron:ipc";
    final IdleStrategy idle = new SleepingIdleStrategy();

    while (true) {
      try (Aeron aeron = Aeron.connect();
          Subscription sub = aeron.addSubscription(channel, 10)) {
        FragmentHandler handler =
            (buffer, offset, length, header) ->
                System.out.println("received:" + buffer.getStringAscii(offset));
        while (sub.poll(handler, 1) <= 0) {
          idle.idle();
        }
      }
    }
  }

  QuoteEncoder get(MutableDirectBuffer buffer, MessageHeaderEncoder headerEncoder) {
    QuoteEncoder quoteEncoder = new QuoteEncoder();
    return quoteEncoder
        .wrapAndApplyHeader(buffer, 0, headerEncoder)
        .symbol("AAPL") // char[4] field
        .bidPrice(150.25) // double
        .bidSize(500) // uint32
        .askPrice(150.30) // double
        .askSize(300) // uint32
        .sendingTime(System.nanoTime()); // uint64 (nanoseconds)
  }
}
