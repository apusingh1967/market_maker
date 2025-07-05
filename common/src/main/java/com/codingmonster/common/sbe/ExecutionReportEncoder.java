/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class ExecutionReportEncoder {
  public static final int BLOCK_LENGTH = 67;
  public static final int TEMPLATE_ID = 200;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final ExecutionReportEncoder parentMessage = this;
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
    return "8";
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

  public ExecutionReportEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public ExecutionReportEncoder wrapAndApplyHeader(
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

  public static int execIdId() {
    return 1;
  }

  public static int execIdSinceVersion() {
    return 0;
  }

  public static int execIdEncodingOffset() {
    return 0;
  }

  public static int execIdEncodingLength() {
    return 8;
  }

  public static String execIdMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long execIdNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long execIdMinValue() {
    return 0x0L;
  }

  public static long execIdMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public ExecutionReportEncoder execId(final long value) {
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

  public ExecutionReportEncoder orderId(final long value) {
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

  public ExecutionReportEncoder clientId(final long value) {
    buffer.putLong(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int execTypeId() {
    return 4;
  }

  public static int execTypeSinceVersion() {
    return 0;
  }

  public static int execTypeEncodingOffset() {
    return 24;
  }

  public static int execTypeEncodingLength() {
    return 1;
  }

  public static String execTypeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public ExecutionReportEncoder execType(final ExecType value) {
    buffer.putByte(offset + 24, (byte) value.value());
    return this;
  }

  public static int ordStatusId() {
    return 5;
  }

  public static int ordStatusSinceVersion() {
    return 0;
  }

  public static int ordStatusEncodingOffset() {
    return 25;
  }

  public static int ordStatusEncodingLength() {
    return 1;
  }

  public static String ordStatusMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public ExecutionReportEncoder ordStatus(final OrdStatus value) {
    buffer.putByte(offset + 25, (byte) value.value());
    return this;
  }

  public static int sideId() {
    return 6;
  }

  public static int sideSinceVersion() {
    return 0;
  }

  public static int sideEncodingOffset() {
    return 26;
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

  public ExecutionReportEncoder side(final Side value) {
    buffer.putByte(offset + 26, (byte) value.value());
    return this;
  }

  public static int priceId() {
    return 7;
  }

  public static int priceSinceVersion() {
    return 0;
  }

  public static int priceEncodingOffset() {
    return 27;
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
    price.wrap(buffer, offset + 27);
    return price;
  }

  public static int cumQtyId() {
    return 8;
  }

  public static int cumQtySinceVersion() {
    return 0;
  }

  public static int cumQtyEncodingOffset() {
    return 36;
  }

  public static int cumQtyEncodingLength() {
    return 4;
  }

  public static String cumQtyMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long cumQtyNullValue() {
    return 4294967295L;
  }

  public static long cumQtyMinValue() {
    return 0L;
  }

  public static long cumQtyMaxValue() {
    return 4294967294L;
  }

  public ExecutionReportEncoder cumQty(final long value) {
    buffer.putInt(offset + 36, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int leavesQtyId() {
    return 9;
  }

  public static int leavesQtySinceVersion() {
    return 0;
  }

  public static int leavesQtyEncodingOffset() {
    return 40;
  }

  public static int leavesQtyEncodingLength() {
    return 4;
  }

  public static String leavesQtyMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long leavesQtyNullValue() {
    return 4294967295L;
  }

  public static long leavesQtyMinValue() {
    return 0L;
  }

  public static long leavesQtyMaxValue() {
    return 4294967294L;
  }

  public ExecutionReportEncoder leavesQty(final long value) {
    buffer.putInt(offset + 40, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int lastQtyId() {
    return 10;
  }

  public static int lastQtySinceVersion() {
    return 0;
  }

  public static int lastQtyEncodingOffset() {
    return 44;
  }

  public static int lastQtyEncodingLength() {
    return 4;
  }

  public static String lastQtyMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long lastQtyNullValue() {
    return 4294967295L;
  }

  public static long lastQtyMinValue() {
    return 0L;
  }

  public static long lastQtyMaxValue() {
    return 4294967294L;
  }

  public ExecutionReportEncoder lastQty(final long value) {
    buffer.putInt(offset + 44, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int lastPriceId() {
    return 11;
  }

  public static int lastPriceSinceVersion() {
    return 0;
  }

  public static int lastPriceEncodingOffset() {
    return 48;
  }

  public static int lastPriceEncodingLength() {
    return 9;
  }

  public static String lastPriceMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  private final DecimalEncoder lastPrice = new DecimalEncoder();

  public DecimalEncoder lastPrice() {
    lastPrice.wrap(buffer, offset + 48);
    return lastPrice;
  }

  public static int timestampId() {
    return 12;
  }

  public static int timestampSinceVersion() {
    return 0;
  }

  public static int timestampEncodingOffset() {
    return 57;
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

  public ExecutionReportEncoder timestamp(final long value) {
    buffer.putLong(offset + 57, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int reasonCodeId() {
    return 13;
  }

  public static int reasonCodeSinceVersion() {
    return 0;
  }

  public static int reasonCodeEncodingOffset() {
    return 65;
  }

  public static int reasonCodeEncodingLength() {
    return 2;
  }

  public static String reasonCodeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static int reasonCodeNullValue() {
    return 65535;
  }

  public static int reasonCodeMinValue() {
    return 0;
  }

  public static int reasonCodeMaxValue() {
    return 65534;
  }

  public ExecutionReportEncoder reasonCode(final int value) {
    buffer.putShort(offset + 65, (short) value, java.nio.ByteOrder.LITTLE_ENDIAN);
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

    final ExecutionReportDecoder decoder = new ExecutionReportDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
