package com.as.common;

import com.as.common.codec.MessageHeaderDecoder;
import com.as.common.codec.MessageHeaderEncoder;
import com.as.common.codec.QuoteDecoder;
import com.as.common.codec.QuoteEncoder;
import java.nio.ByteBuffer;
import org.agrona.MutableDirectBuffer;
import org.agrona.concurrent.UnsafeBuffer;

public class SbeTest {
  public static void main(String[] args) {
    // 1. Allocate a buffer (e.g., 256 bytes)
    final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(256);
    final MutableDirectBuffer buffer = new UnsafeBuffer(byteBuffer);

    // 2. Encode the message header
    MessageHeaderEncoder headerEncoder = new MessageHeaderEncoder();
    QuoteEncoder quoteEncoder = new QuoteEncoder();

    // 3. Write header + quote
    quoteEncoder
        .wrapAndApplyHeader(buffer, 0, headerEncoder)
        .symbol("AAPL") // char[4] field
        .bidPrice(150.25) // double
        .bidSize(500) // uint32
        .askPrice(150.30) // double
        .askSize(300) // uint32
        .sendingTime(System.nanoTime()); // uint64 (nanoseconds)

    // 4. Get encoded bytes (for sending over network)
    int encodedLength = headerEncoder.encodedLength() + quoteEncoder.encodedLength();
    byte[] encodedBytes = new byte[encodedLength];
    buffer.getBytes(0, encodedBytes);

    MessageHeaderDecoder headerDecoder = new MessageHeaderDecoder();
    QuoteDecoder decoder = new QuoteDecoder();
    int offset = 0;
    headerDecoder.wrap(buffer, offset);

    int templateId = headerDecoder.templateId();
    final int blockLength = headerDecoder.blockLength();
    final int version = headerDecoder.version();
    offset += headerDecoder.encodedLength();
    decoder.wrap(buffer, offset, blockLength, version);

    System.out.println("********");
    System.out.println(templateId);
    System.out.println(decoder.askPrice());
    System.out.println(decoder.symbol());
  }
}
