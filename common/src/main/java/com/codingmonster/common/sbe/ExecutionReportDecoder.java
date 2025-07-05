/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public final class ExecutionReportDecoder {
  public static final int BLOCK_LENGTH = 67;
  public static final int TEMPLATE_ID = 200;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final ExecutionReportDecoder parentMessage = this;
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
    return "8";
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

  public ExecutionReportDecoder wrap(
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

  public ExecutionReportDecoder wrapAndApplyHeader(
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

  public ExecutionReportDecoder sbeRewind() {
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

  public long execId() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public long orderId() {
    return buffer.getLong(offset + 8, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public long clientId() {
    return buffer.getLong(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public short execTypeRaw() {
    return ((short) (buffer.getByte(offset + 24) & 0xFF));
  }

  public ExecType execType() {
    return ExecType.get(((short) (buffer.getByte(offset + 24) & 0xFF)));
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

  public short ordStatusRaw() {
    return ((short) (buffer.getByte(offset + 25) & 0xFF));
  }

  public OrdStatus ordStatus() {
    return OrdStatus.get(((short) (buffer.getByte(offset + 25) & 0xFF)));
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

  public short sideRaw() {
    return ((short) (buffer.getByte(offset + 26) & 0xFF));
  }

  public Side side() {
    return Side.get(((short) (buffer.getByte(offset + 26) & 0xFF)));
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

  private final DecimalDecoder price = new DecimalDecoder();

  public DecimalDecoder price() {
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

  public long cumQty() {
    return (buffer.getInt(offset + 36, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

  public long leavesQty() {
    return (buffer.getInt(offset + 40, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

  public long lastQty() {
    return (buffer.getInt(offset + 44, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

  private final DecimalDecoder lastPrice = new DecimalDecoder();

  public DecimalDecoder lastPrice() {
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

  public long timestamp() {
    return buffer.getLong(offset + 57, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public int reasonCode() {
    return (buffer.getShort(offset + 65, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    final ExecutionReportDecoder decoder = new ExecutionReportDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[ExecutionReport](sbeTemplateId=");
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
    builder.append("execId=");
    builder.append(this.execId());
    builder.append('|');
    builder.append("orderId=");
    builder.append(this.orderId());
    builder.append('|');
    builder.append("clientId=");
    builder.append(this.clientId());
    builder.append('|');
    builder.append("execType=");
    builder.append(this.execType());
    builder.append('|');
    builder.append("ordStatus=");
    builder.append(this.ordStatus());
    builder.append('|');
    builder.append("side=");
    builder.append(this.side());
    builder.append('|');
    builder.append("price=");
    final DecimalDecoder price = this.price();
    if (price != null) {
      price.appendTo(builder);
    } else {
      builder.append("null");
    }
    builder.append('|');
    builder.append("cumQty=");
    builder.append(this.cumQty());
    builder.append('|');
    builder.append("leavesQty=");
    builder.append(this.leavesQty());
    builder.append('|');
    builder.append("lastQty=");
    builder.append(this.lastQty());
    builder.append('|');
    builder.append("lastPrice=");
    final DecimalDecoder lastPrice = this.lastPrice();
    if (lastPrice != null) {
      lastPrice.appendTo(builder);
    } else {
      builder.append("null");
    }
    builder.append('|');
    builder.append("timestamp=");
    builder.append(this.timestamp());
    builder.append('|');
    builder.append("reasonCode=");
    builder.append(this.reasonCode());

    limit(originalLimit);

    return builder;
  }

  public ExecutionReportDecoder sbeSkip() {
    sbeRewind();

    return this;
  }
}
