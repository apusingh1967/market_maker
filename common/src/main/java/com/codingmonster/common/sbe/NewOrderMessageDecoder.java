/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public final class NewOrderMessageDecoder {
  public static final int BLOCK_LENGTH = 48;
  public static final int TEMPLATE_ID = 100;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final NewOrderMessageDecoder parentMessage = this;
  private DirectBuffer buffer;
  private int initialOffset;
  private int offset;
  private int limit;
  int actingBlockLength;
  int actingVersion;

  public int sbeBlockLength() {
    return BLOCK_LENGTH;
  }

  public int sbeTemplateId() {
    return TEMPLATE_ID;
  }

  public int sbeSchemaId() {
    return SCHEMA_ID;
  }

  public int sbeSchemaVersion() {
    return SCHEMA_VERSION;
  }

  public String sbeSemanticType() {
    return "D";
  }

  public DirectBuffer buffer() {
    return buffer;
  }

  public int initialOffset() {
    return initialOffset;
  }

  public int offset() {
    return offset;
  }

  public NewOrderMessageDecoder wrap(
      final DirectBuffer buffer,
      final int offset,
      final int actingBlockLength,
      final int actingVersion) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    this.actingBlockLength = actingBlockLength;
    this.actingVersion = actingVersion;
    limit(offset + actingBlockLength);

    return this;
  }

  public NewOrderMessageDecoder wrapAndApplyHeader(
      final DirectBuffer buffer, final int offset, final MessageHeaderDecoder headerDecoder) {
    headerDecoder.wrap(buffer, offset);

    final int templateId = headerDecoder.templateId();
    if (TEMPLATE_ID != templateId) {
      throw new IllegalStateException("Invalid TEMPLATE_ID: " + templateId);
    }

    return wrap(
        buffer,
        offset + MessageHeaderDecoder.ENCODED_LENGTH,
        headerDecoder.blockLength(),
        headerDecoder.version());
  }

  public NewOrderMessageDecoder sbeRewind() {
    return wrap(buffer, initialOffset, actingBlockLength, actingVersion);
  }

  public int sbeDecodedLength() {
    final int currentLimit = limit();
    sbeSkip();
    final int decodedLength = encodedLength();
    limit(currentLimit);

    return decodedLength;
  }

  public int encodedLength() {
    return limit - offset;
  }

  public int limit() {
    return limit;
  }

  public void limit(final int limit) {
    this.limit = limit;
  }

  public static int orderIdId() {
    return 1;
  }

  public static int orderIdSinceVersion() {
    return 0;
  }

  public static int orderIdEncodingOffset() {
    return 0;
  }

  public static int orderIdEncodingLength() {
    return 8;
  }

  public static String orderIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long orderIdNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long orderIdMinValue() {
    return 0x0L;
  }

  public static long orderIdMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long orderId() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int clientIdId() {
    return 2;
  }

  public static int clientIdSinceVersion() {
    return 0;
  }

  public static int clientIdEncodingOffset() {
    return 8;
  }

  public static int clientIdEncodingLength() {
    return 8;
  }

  public static String clientIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long clientIdNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long clientIdMinValue() {
    return 0x0L;
  }

  public static long clientIdMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long clientId() {
    return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public static int symbolId() {
    return 3;
  }

  public static int symbolSinceVersion() {
    return 0;
  }

  public static int symbolEncodingOffset() {
    return 16;
  }

  public static int symbolEncodingLength() {
    return 8;
  }

  public static String symbolMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static byte symbolNullValue() {
    return (byte) 0;
  }

  public static byte symbolMinValue() {
    return (byte) 32;
  }

  public static byte symbolMaxValue() {
    return (byte) 126;
  }

  public static int symbolLength() {
    return 8;
  }

  public byte symbol(final int index) {
    if (index < 0 || index >= 8) {
      throw new IndexOutOfBoundsException("index out of range: index=" + index);
    }

    final int pos = offset + 16 + (index * 1);

    return buffer.getByte(pos);
  }

  public static String symbolCharacterEncoding() {
    return java.nio.charset.StandardCharsets.US_ASCII.name();
  }

  public int getSymbol(final byte[] dst, final int dstOffset) {
    final int length = 8;
    if (dstOffset < 0 || dstOffset > (dst.length - length)) {
      throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + dstOffset);
    }

    buffer.getBytes(offset + 16, dst, dstOffset, length);

    return length;
  }

  public String symbol() {
    final byte[] dst = new byte[8];
    buffer.getBytes(offset + 16, dst, 0, 8);

    int end = 0;
    for (; end < 8 && dst[end] != 0; ++end)
      ;

    return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
  }

  public int getSymbol(final Appendable value) {
    for (int i = 0; i < 8; ++i) {
      final int c = buffer.getByte(offset + 16 + i) & 0xFF;
      if (c == 0) {
        return i;
      }

      try {
        value.append(c > 127 ? '?' : (char) c);
      } catch (final java.io.IOException ex) {
        throw new java.io.UncheckedIOException(ex);
      }
    }

    return 8;
  }

  public static int sideId() {
    return 4;
  }

  public static int sideSinceVersion() {
    return 0;
  }

  public static int sideEncodingOffset() {
    return 24;
  }

  public static int sideEncodingLength() {
    return 1;
  }

  public static String sideMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public short sideRaw() {
    return ((short) (buffer.getByte(offset + 24) & 0xFF));
  }

  public Side side() {
    return Side.get(((short) (buffer.getByte(offset + 24) & 0xFF)));
  }

  public static int orderTypeId() {
    return 5;
  }

  public static int orderTypeSinceVersion() {
    return 0;
  }

  public static int orderTypeEncodingOffset() {
    return 25;
  }

  public static int orderTypeEncodingLength() {
    return 1;
  }

  public static String orderTypeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public short orderTypeRaw() {
    return ((short) (buffer.getByte(offset + 25) & 0xFF));
  }

  public OrderType orderType() {
    return OrderType.get(((short) (buffer.getByte(offset + 25) & 0xFF)));
  }

  public static int quantityId() {
    return 6;
  }

  public static int quantitySinceVersion() {
    return 0;
  }

  public static int quantityEncodingOffset() {
    return 26;
  }

  public static int quantityEncodingLength() {
    return 4;
  }

  public static String quantityMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long quantityNullValue() {
    return 4294967295L;
  }

  public static long quantityMinValue() {
    return 0L;
  }

  public static long quantityMaxValue() {
    return 4294967294L;
  }

  public long quantity() {
    return (buffer.getInt(offset + 26, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
  }

  public static int priceId() {
    return 7;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 30;
  }

  public static int priceEncodingLength() {
    return 9;
  }

  public static String priceMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  private final DecimalDecoder price = new DecimalDecoder();

  public DecimalDecoder price() {
    price.wrap(buffer, offset + 30);
    return price;
  }

  public static int timeInForceId() {
    return 8;
  }

  public static int timeInForceSinceVersion() {
    return 0;
  }

  public static int timeInForceEncodingOffset() {
    return 39;
  }

  public static int timeInForceEncodingLength() {
    return 1;
  }

  public static String timeInForceMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public short timeInForceRaw() {
    return ((short) (buffer.getByte(offset + 39) & 0xFF));
  }

  public TimeInForce timeInForce() {
    return TimeInForce.get(((short) (buffer.getByte(offset + 39) & 0xFF)));
  }

  public static int timestampId() {
    return 9;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return 40;
  }

  public static int timestampEncodingLength() {
    return 8;
  }

  public static String timestampMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long timestampNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long timestampMinValue() {
    return 0x0L;
  }

  public static long timestampMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public long timestamp() {
    return buffer.getLong(offset + 40, java.nio.ByteOrder.LITTLE_ENDIAN);
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    final NewOrderMessageDecoder decoder = new NewOrderMessageDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[NewOrderMessage](sbeTemplateId=");
    builder.append(TEMPLATE_ID);
    builder.append("|sbeSchemaId=");
    builder.append(SCHEMA_ID);
    builder.append("|sbeSchemaVersion=");
    if (parentMessage.actingVersion != SCHEMA_VERSION) {
      builder.append(parentMessage.actingVersion);
      builder.append('/');
    }
    builder.append(SCHEMA_VERSION);
    builder.append("|sbeBlockLength=");
    if (actingBlockLength != BLOCK_LENGTH) {
      builder.append(actingBlockLength);
      builder.append('/');
    }
    builder.append(BLOCK_LENGTH);
    builder.append("):");
    builder.append("orderId=");
    builder.append(this.orderId());
    builder.append('|');
    builder.append("clientId=");
    builder.append(this.clientId());
    builder.append('|');
    builder.append("symbol=");
    for (int i = 0; i < symbolLength() && this.symbol(i) > 0; i++) {
      builder.append((char) this.symbol(i));
    }
    builder.append('|');
    builder.append("side=");
    builder.append(this.side());
    builder.append('|');
    builder.append("orderType=");
    builder.append(this.orderType());
    builder.append('|');
    builder.append("quantity=");
    builder.append(this.quantity());
    builder.append('|');
    builder.append("price=");
    final DecimalDecoder price = this.price();
    if (price != null) {
      price.appendTo(builder);
    } else {
      builder.append("null");
    }
    builder.append('|');
    builder.append("timeInForce=");
    builder.append(this.timeInForce());
    builder.append('|');
    builder.append("timestamp=");
    builder.append(this.timestamp());

    limit(originalLimit);

    return builder;
  }

  public NewOrderMessageDecoder sbeSkip() {
    sbeRewind();

    return this;
  }
}
