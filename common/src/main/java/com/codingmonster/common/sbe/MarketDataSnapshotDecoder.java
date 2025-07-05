/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.DirectBuffer;

@SuppressWarnings("all")
public final class MarketDataSnapshotDecoder {
  public static final int BLOCK_LENGTH = 25;
  public static final int TEMPLATE_ID = 300;
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private final MarketDataSnapshotDecoder parentMessage = this;
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
    return "W";
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

  public MarketDataSnapshotDecoder wrap(
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

  public MarketDataSnapshotDecoder wrapAndApplyHeader(
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

  public MarketDataSnapshotDecoder sbeRewind() {
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

  public long mDReqID() {
    return buffer.getLong(offset + 0, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public byte symbol(final int index) {
    if (index < 0 || index >= 8) {
      throw new IndexOutOfBoundsException("index out of range: index=" + index);
    }

    final int pos = offset + 8 + (index * 1);

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

    buffer.getBytes(offset + 8, dst, dstOffset, length);

    return length;
  }

  public String symbol() {
    final byte[] dst = new byte[8];
    buffer.getBytes(offset + 8, dst, 0, 8);

    int end = 0;
    for (; end < 8 && dst[end] != 0; ++end)
      ;

    return new String(dst, 0, end, java.nio.charset.StandardCharsets.US_ASCII);
  }

  public int getSymbol(final Appendable value) {
    for (int i = 0; i < 8; ++i) {
      final int c = buffer.getByte(offset + 8 + i) & 0xFF;
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

  public long lastUpdateTime() {
    return buffer.getLong(offset + 16, java.nio.ByteOrder.LITTLE_ENDIAN);
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

  public short noPriceLevels() {
    return ((short) (buffer.getByte(offset + 24) & 0xFF));
  }

  private final PriceLevelsDecoder priceLevels = new PriceLevelsDecoder(this);

  public static long priceLevelsDecoderId() {
    return 5;
  }

  public static int priceLevelsDecoderSinceVersion() {
    return 0;
  }

  public PriceLevelsDecoder priceLevels() {
    priceLevels.wrap(buffer);
    return priceLevels;
  }

  public static final class PriceLevelsDecoder
      implements Iterable<PriceLevelsDecoder>, java.util.Iterator<PriceLevelsDecoder> {
    public static final int HEADER_SIZE = 4;
    private final MarketDataSnapshotDecoder parentMessage;
    private DirectBuffer buffer;
    private int count;
    private int index;
    private int offset;
    private int blockLength;

    PriceLevelsDecoder(final MarketDataSnapshotDecoder parentMessage) {
      this.parentMessage = parentMessage;
    }

    public void wrap(final DirectBuffer buffer) {
      if (buffer != this.buffer) {
        this.buffer = buffer;
      }

      index = 0;
      final int limit = parentMessage.limit();
      parentMessage.limit(limit + HEADER_SIZE);
      blockLength = (buffer.getShort(limit + 0, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
      count = (buffer.getShort(limit + 2, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF);
    }

    public PriceLevelsDecoder next() {
      if (index >= count) {
        throw new java.util.NoSuchElementException();
      }

      offset = parentMessage.limit();
      parentMessage.limit(offset + blockLength);
      ++index;

      return this;
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

    public int actingBlockLength() {
      return blockLength;
    }

    public int count() {
      return count;
    }

    public java.util.Iterator<PriceLevelsDecoder> iterator() {
      return this;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
      return index < count;
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

    private final DecimalDecoder bidPrice = new DecimalDecoder();

    public DecimalDecoder bidPrice() {
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

    public long bidSize() {
      return (buffer.getInt(offset + 9, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    private final DecimalDecoder offerPrice = new DecimalDecoder();

    public DecimalDecoder offerPrice() {
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

    public long offerSize() {
      return (buffer.getInt(offset + 22, java.nio.ByteOrder.LITTLE_ENDIAN) & 0xFFFF_FFFFL);
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

    public short priceLevelPosition() {
      return ((short) (buffer.getByte(offset + 26) & 0xFF));
    }

    public StringBuilder appendTo(final StringBuilder builder) {
      if (null == buffer) {
        return builder;
      }

      builder.append('(');
      builder.append("bidPrice=");
      final DecimalDecoder bidPrice = this.bidPrice();
      if (bidPrice != null) {
        bidPrice.appendTo(builder);
      } else {
        builder.append("null");
      }
      builder.append('|');
      builder.append("bidSize=");
      builder.append(this.bidSize());
      builder.append('|');
      builder.append("offerPrice=");
      final DecimalDecoder offerPrice = this.offerPrice();
      if (offerPrice != null) {
        offerPrice.appendTo(builder);
      } else {
        builder.append("null");
      }
      builder.append('|');
      builder.append("offerSize=");
      builder.append(this.offerSize());
      builder.append('|');
      builder.append("priceLevelPosition=");
      builder.append(this.priceLevelPosition());
      builder.append(')');

      return builder;
    }

    public PriceLevelsDecoder sbeSkip() {

      return this;
    }
  }

  public String toString() {
    if (null == buffer) {
      return "";
    }

    final MarketDataSnapshotDecoder decoder = new MarketDataSnapshotDecoder();
    decoder.wrap(buffer, initialOffset, actingBlockLength, actingVersion);

    return decoder.appendTo(new StringBuilder()).toString();
  }

  public StringBuilder appendTo(final StringBuilder builder) {
    if (null == buffer) {
      return builder;
    }

    final int originalLimit = limit();
    limit(initialOffset + actingBlockLength);
    builder.append("[MarketDataSnapshot](sbeTemplateId=");
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
    builder.append("mDReqID=");
    builder.append(this.mDReqID());
    builder.append('|');
    builder.append("symbol=");
    for (int i = 0; i < symbolLength() && this.symbol(i) > 0; i++) {
      builder.append((char) this.symbol(i));
    }
    builder.append('|');
    builder.append("lastUpdateTime=");
    builder.append(this.lastUpdateTime());
    builder.append('|');
    builder.append("noPriceLevels=");
    builder.append(this.noPriceLevels());
    builder.append('|');
    builder.append("priceLevels=[");
    final int priceLevelsOriginalOffset = priceLevels.offset;
    final int priceLevelsOriginalIndex = priceLevels.index;
    final PriceLevelsDecoder priceLevels = this.priceLevels();
    if (priceLevels.count() > 0) {
      while (priceLevels.hasNext()) {
        priceLevels.next().appendTo(builder);
        builder.append(',');
      }
      builder.setLength(builder.length() - 1);
    }
    priceLevels.offset = priceLevelsOriginalOffset;
    priceLevels.index = priceLevelsOriginalIndex;
    builder.append(']');

    limit(originalLimit);

    return builder;
  }

  public MarketDataSnapshotDecoder sbeSkip() {
    sbeRewind();
    PriceLevelsDecoder priceLevels = this.priceLevels();
    if (priceLevels.count() > 0) {
      while (priceLevels.hasNext()) {
        priceLevels.next();
        priceLevels.sbeSkip();
      }
    }

    return this;
  }
}
