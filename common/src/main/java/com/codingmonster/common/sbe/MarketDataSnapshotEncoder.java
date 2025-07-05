/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.MutableDirectBuffer;

@SuppressWarnings("all")
public final class MarketDataSnapshotEncoder {
  public static final int BLOCK_LENGTH = 25;
  public static final int TEMPLATE_ID = 300;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final MarketDataSnapshotEncoder parentMessage = this;
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
    return "W";
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

  public MarketDataSnapshotEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.initialOffset = offset;
    this.offset = offset;
    limit(offset + BLOCK_LENGTH);

    return this;
  }

  public MarketDataSnapshotEncoder wrapAndApplyHeader(
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

  public static int mDReqIDId() {
    return 1;
  }

  public static int mDReqIDSinceVersion() {
    return 0;
  }

  public static int mDReqIDEncodingOffset() {
    return 0;
  }

  public static int mDReqIDEncodingLength() {
    return 8;
  }

  public static String mDReqIDMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long mDReqIDNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long mDReqIDMinValue() {
    return 0x0L;
  }

  public static long mDReqIDMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public MarketDataSnapshotEncoder mDReqID(final long value) {
    buffer.putLong(offset + 0, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int symbolId() {
    return 2;
  }

  public static int symbolSinceVersion() {
    return 0;
  }

  public static int symbolEncodingOffset() {
    return 8;
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

  public MarketDataSnapshotEncoder symbol(final int index, final byte value) {
    if (index < 0 || index >= 8) {
      throw new IndexOutOfBoundsException("index out of range: index=" + index);
    }

    final int pos = offset + 8 + (index * 1);
    buffer.putByte(pos, value);

    return this;
  }

  public static String symbolCharacterEncoding() {
    return java.nio.charset.StandardCharsets.US_ASCII.name();
  }

  public MarketDataSnapshotEncoder putSymbol(final byte[] src, final int srcOffset) {
    final int length = 8;
    if (srcOffset < 0 || srcOffset > (src.length - length)) {
      throw new IndexOutOfBoundsException("Copy will go out of range: offset=" + srcOffset);
    }

    buffer.putBytes(offset + 8, src, srcOffset, length);

    return this;
  }

  public MarketDataSnapshotEncoder symbol(final String src) {
    final int length = 8;
    final int srcLength = null == src ? 0 : src.length();
    if (srcLength > length) {
      throw new IndexOutOfBoundsException("String too large for copy: byte length=" + srcLength);
    }

    buffer.putStringWithoutLengthAscii(offset + 8, src);

    for (int start = srcLength; start < length; ++start) {
      buffer.putByte(offset + 8 + start, (byte) 0);
    }

    return this;
  }

  public MarketDataSnapshotEncoder symbol(final CharSequence src) {
    final int length = 8;
    final int srcLength = null == src ? 0 : src.length();
    if (srcLength > length) {
      throw new IndexOutOfBoundsException(
          "CharSequence too large for copy: byte length=" + srcLength);
    }

    buffer.putStringWithoutLengthAscii(offset + 8, src);

    for (int start = srcLength; start < length; ++start) {
      buffer.putByte(offset + 8 + start, (byte) 0);
    }

    return this;
  }

  public static int lastUpdateTimeId() {
    return 3;
  }

  public static int lastUpdateTimeSinceVersion() {
    return 0;
  }

  public static int lastUpdateTimeEncodingOffset() {
    return 16;
  }

  public static int lastUpdateTimeEncodingLength() {
    return 8;
  }

  public static String lastUpdateTimeMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static long lastUpdateTimeNullValue() {
    return 0xffffffffffffffffL;
  }

  public static long lastUpdateTimeMinValue() {
    return 0x0L;
  }

  public static long lastUpdateTimeMaxValue() {
    return 0xfffffffffffffffeL;
  }

  public MarketDataSnapshotEncoder lastUpdateTime(final long value) {
    buffer.putLong(offset + 16, value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int noPriceLevelsId() {
    return 4;
  }

  public static int noPriceLevelsSinceVersion() {
    return 0;
  }

  public static int noPriceLevelsEncodingOffset() {
    return 24;
  }

  public static int noPriceLevelsEncodingLength() {
    return 1;
  }

  public static String noPriceLevelsMetaAttribute(final MetaAttribute metaAttribute) {
    if (MetaAttribute.PRESENCE == metaAttribute) {
      return "required";
    }

    return "";
  }

  public static short noPriceLevelsNullValue() {
    return (short) 255;
  }

  public static short noPriceLevelsMinValue() {
    return (short) 0;
  }

  public static short noPriceLevelsMaxValue() {
    return (short) 254;
  }

  public MarketDataSnapshotEncoder noPriceLevels(final short value) {
    buffer.putByte(offset + 24, (byte) value);
    return this;
  }

  private final PriceLevelsEncoder priceLevels = new PriceLevelsEncoder(this);

  public static long priceLevelsId() {
    return 5;
  }

  public PriceLevelsEncoder priceLevelsCount(final int count) {
    priceLevels.wrap(buffer, count);
    return priceLevels;
  }

  public static final class PriceLevelsEncoder {
    public static final int HEADER_SIZE = 4;
    private final MarketDataSnapshotEncoder parentMessage;
    private MutableDirectBuffer buffer;
    private int count;
    private int index;
    private int offset;
    private int initialLimit;

    PriceLevelsEncoder(final MarketDataSnapshotEncoder parentMessage) {
      this.parentMessage = parentMessage;
    }

    public void wrap(final MutableDirectBuffer buffer, final int count) {
      if (count < 0 || count > 65534) {
        throw new IllegalArgumentException("count outside allowed range: count=" + count);
      }

      if (buffer != this.buffer) {
        this.buffer = buffer;
      }

      index = 0;
      this.count = count;
      final int limit = parentMessage.limit();
      initialLimit = limit;
      parentMessage.limit(limit + HEADER_SIZE);
      buffer.putShort(limit + 0, (short) 27, java.nio.ByteOrder.LITTLE_ENDIAN);
      buffer.putShort(limit + 2, (short) count, java.nio.ByteOrder.LITTLE_ENDIAN);
    }

    public PriceLevelsEncoder next() {
      if (index >= count) {
        throw new java.util.NoSuchElementException();
      }

      offset = parentMessage.limit();
      parentMessage.limit(offset + sbeBlockLength());
      ++index;

      return this;
    }

    public int resetCountToIndex() {
      count = index;
      buffer.putShort(initialLimit + 2, (short) count, java.nio.ByteOrder.LITTLE_ENDIAN);

      return count;
    }

    public static int countMinValue() {
      return 0;
    }

    public static int countMaxValue() {
      return 65534;
    }

    public static int sbeHeaderSize() {
      return HEADER_SIZE;
    }

    public static int sbeBlockLength() {
      return 27;
    }

    public static int bidPriceId() {
      return 6;
    }

    public static int bidPriceSinceVersion() {
      return 0;
    }

    public static int bidPriceEncodingOffset() {
      return 0;
    }

    public static int bidPriceEncodingLength() {
      return 9;
    }

    public static String bidPriceMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    private final DecimalEncoder bidPrice = new DecimalEncoder();

    public DecimalEncoder bidPrice() {
      bidPrice.wrap(buffer, offset + 0);
      return bidPrice;
    }

    public static int bidSizeId() {
      return 7;
    }

    public static int bidSizeSinceVersion() {
      return 0;
    }

    public static int bidSizeEncodingOffset() {
      return 9;
    }

    public static int bidSizeEncodingLength() {
      return 4;
    }

    public static String bidSizeMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    public static long bidSizeNullValue() {
      return 4294967295L;
    }

    public static long bidSizeMinValue() {
      return 0L;
    }

    public static long bidSizeMaxValue() {
      return 4294967294L;
    }

    public PriceLevelsEncoder bidSize(final long value) {
      buffer.putInt(offset + 9, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
      return this;
    }

    public static int offerPriceId() {
      return 8;
    }

    public static int offerPriceSinceVersion() {
      return 0;
    }

    public static int offerPriceEncodingOffset() {
      return 13;
    }

    public static int offerPriceEncodingLength() {
      return 9;
    }

    public static String offerPriceMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    private final DecimalEncoder offerPrice = new DecimalEncoder();

    public DecimalEncoder offerPrice() {
      offerPrice.wrap(buffer, offset + 13);
      return offerPrice;
    }

    public static int offerSizeId() {
      return 9;
    }

    public static int offerSizeSinceVersion() {
      return 0;
    }

    public static int offerSizeEncodingOffset() {
      return 22;
    }

    public static int offerSizeEncodingLength() {
      return 4;
    }

    public static String offerSizeMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    public static long offerSizeNullValue() {
      return 4294967295L;
    }

    public static long offerSizeMinValue() {
      return 0L;
    }

    public static long offerSizeMaxValue() {
      return 4294967294L;
    }

    public PriceLevelsEncoder offerSize(final long value) {
      buffer.putInt(offset + 22, (int) value, java.nio.ByteOrder.LITTLE_ENDIAN);
      return this;
    }

    public static int priceLevelPositionId() {
      return 10;
    }

    public static int priceLevelPositionSinceVersion() {
      return 0;
    }

    public static int priceLevelPositionEncodingOffset() {
      return 26;
    }

    public static int priceLevelPositionEncodingLength() {
      return 1;
    }

    public static String priceLevelPositionMetaAttribute(final MetaAttribute metaAttribute) {
      if (MetaAttribute.PRESENCE == metaAttribute) {
        return "required";
      }

      return "";
    }

    public static short priceLevelPositionNullValue() {
      return (short) 255;
    }

    public static short priceLevelPositionMinValue() {
      return (short) 0;
    }

    public static short priceLevelPositionMaxValue() {
      return (short) 254;
    }

    public PriceLevelsEncoder priceLevelPosition(final short value) {
      buffer.putByte(offset + 26, (byte) value);
      return this;
    }
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

    final MarketDataSnapshotDecoder decoder = new MarketDataSnapshotDecoder();
    decoder.wrap(buffer, initialOffset, BLOCK_LENGTH, SCHEMA_VERSION);

    return decoder.appendTo(builder);
  }
}
