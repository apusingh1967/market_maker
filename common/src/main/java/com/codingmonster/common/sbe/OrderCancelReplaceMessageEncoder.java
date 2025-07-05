/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class OrderCancelReplaceMessageEncoder {
  public static final int BLOCK_LENGTH = 56;
  public static final int TEMPLATE_ID = 101;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final OrderCancelReplaceMessageEncoder parentMessage = this;
  private MutableDirectBuffer buffer;
  private int initialOffset;
  private int offset;
  private int limit;

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
    return "G";
  }

  public MutableDirectBuffer buffer() {
    return buffer;
  }

  public int initialOffset() {
    return initialOffset;
  }

  public int offset() {
    return offset;
  }

  public OrderCancelReplaceMessageEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public OrderCancelReplaceMessageEncoder wrapAndApplyHeader(
      final MutableDirectBuffer buffer,
      final int offset,
      final MessageHeaderEncoder headerEncoder) {
    headerEncoder
        .wrap(buffer, offset)
        .blockLength(BLOCK_LENGTH)
        .templateId(TEMPLATE_ID)
        .schemaId(SCHEMA_ID)
        .version(SCHEMA_VERSION);

    return wrap(buffer, offset + MessageHeaderEncoder.ENCODED_LENGTH);
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

  public static int origOrderIdId() {
    return 1;
  }

  public static int origOrderIdSinceVersion() {
    return 0;
  }

  public static int origOrderIdEncodingOffset() {
    return 0;
  }

  public static int origOrderIdEncodingLength() {
    return 8;
  }

  public static String origOrderIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long origOrderIdNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long origOrderIdMinValue() {
    return 0x0L;
  }

  public static long origOrderIdMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public OrderCancelReplaceMessageEncoder origOrderId(final long value) {
    buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int orderIdId() {
    return 2;
  }

  public static int orderIdSinceVersion() {
    return 0;
  }

  public static int orderIdEncodingOffset() {
    return 8;
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

  public OrderCancelReplaceMessageEncoder orderId(final long value) {
    buffer.putLong(offset + 8, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int clientIdId() {
    return 3;
  }

  public static int clientIdSinceVersion() {
    return 0;
  }

  public static int clientIdEncodingOffset() {
    return 16;
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

  public OrderCancelReplaceMessageEncoder clientId(final long value) {
    buffer.putLong(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int symbolId() {
    return 4;
  }

  public static int symbolSinceVersion() {
    return 0;
  }

  public static int symbolEncodingOffset() {
    return 24;
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

  public OrderCancelReplaceMessageEncoder symbol(final int index, final byte value) {
    if (index < 0 || index >= 8) {
      throw new IndexOutOfBoundsException("index out of range: index=" + index);
    }

    final int pos = offset + 24 + (index * 1);
    buffer.putByte(pos, value);

    return this;
  }

  public static String symbolCharacterEncoding() {
    return java.nio.charset.StandardCharsets.US_ASCII.name();
  }

  public OrderCancelReplaceMessageEncoder putSymbol(final byte[] src, final int srcOffset) {
    final int length = 8;
    if (srcOffset < 0 || srcOffset > (src.length - length)) {
      throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
    }

    buffer.putBytes(offset + 24, src, srcOffset, length);

    return this;
  }

  public OrderCancelReplaceMessageEncoder symbol(final String src) {
    final int length = 8;
    final int srcLength = null == src ? 0 : src.length();
    if (srcLength > length) {
      throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
    }

    buffer.putStringWithoutLengthAscii(offset + 24, src);

    for (int start = srcLength; start < length; ++start) {
      buffer.putByte(offset + 24 + start, (byte) 0);
    }

    return this;
  }

  public OrderCancelReplaceMessageEncoder symbol(final CharSequence src) {
    final int length = 8;
    final int srcLength = null == src ? 0 : src.length();
    if (srcLength > length) {
      throw new IndexOutOfBoundsException(
          "CharSequence too large for copy: byte length=" + srcLength);
    }

    buffer.putStringWithoutLengthAscii(offset + 24, src);

    for (int start = srcLength; start < length; ++start) {
      buffer.putByte(offset + 24 + start, (byte) 0);
    }

    return this;
  }

  public static int sideId() {
    return 5;
  }

  public static int sideSinceVersion() {
    return 0;
  }

  public static int sideEncodingOffset() {
    return 32;
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

  public OrderCancelReplaceMessageEncoder side(final Side value) {
    buffer.putByte(offset + 32, (byte) value.value());
    return this;
  }

  public static int orderTypeId() {
    return 6;
  }

  public static int orderTypeSinceVersion() {
    return 0;
  }

  public static int orderTypeEncodingOffset() {
    return 33;
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

  public OrderCancelReplaceMessageEncoder orderType(final OrderType value) {
    buffer.putByte(offset + 33, (byte) value.value());
    return this;
  }

  public static int quantityId() {
    return 7;
  }

  public static int quantitySinceVersion() {
    return 0;
  }

  public static int quantityEncodingOffset() {
    return 34;
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

  public OrderCancelReplaceMessageEncoder quantity(final long value) {
    buffer.putInt(offset + 34, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int priceId() {
    return 8;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 38;
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

  private final DecimalEncoder price = new DecimalEncoder();

  public DecimalEncoder price() {
    price.wrap(buffer, offset + 38);
    return price;
  }

  public static int timeInForceId() {
    return 9;
  }

  public static int timeInForceSinceVersion() {
    return 0;
  }

  public static int timeInForceEncodingOffset() {
    return 47;
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

  public OrderCancelReplaceMessageEncoder timeInForce(final TimeInForce value) {
    buffer.putByte(offset + 47, (byte) value.value());
    return this;
  }

  public static int timestampId() {
    return 10;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return 48;
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

  public OrderCancelReplaceMessageEncoder timestamp(final long value) {
    buffer.putLong(offset + 48, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    return appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final OrderCancelReplaceMessageDecoder decoder = new OrderCancelReplaceMessageDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
