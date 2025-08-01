/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

import org.agrona.MutableDirectBuffer;

/** Standard repeating group dimensions */
@SuppressWarnings("all")
public final class GroupSizeEncodingEncoder {
  public static final int SCHEMA_ID = 1;
  public static final int SCHEMA_VERSION = 0;
  public static final int ENCODED_LENGTH = 4;
  public static final java.nio.ByteOrder BYTE_ORDER = java.nio.ByteOrder.LITTLE_ENDIAN;

  private int offset;
  private MutableDirectBuffer buffer;

  public GroupSizeEncodingEncoder wrap(final MutableDirectBuffer buffer, final int offset) {
    if (buffer != this.buffer) {
      this.buffer = buffer;
    }
    this.offset = offset;

    return this;
  }

  public MutableDirectBuffer buffer() {
    return buffer;
  }

  public int offset() {
    return offset;
  }

  public int encodedLength() {
    return ENCODED_LENGTH;
  }

  public int sbeSchemaId() {
    return SCHEMA_ID;
  }

  public int sbeSchemaVersion() {
    return SCHEMA_VERSION;
  }

  public static int blockLengthEncodingOffset() {
    return 0;
  }

  public static int blockLengthEncodingLength() {
    return 2;
  }

  public static int blockLengthNullValue() {
    return 65535;
  }

  public static int blockLengthMinValue() {
    return 0;
  }

  public static int blockLengthMaxValue() {
    return 65534;
  }

  public GroupSizeEncodingEncoder blockLength(final int value) {
    buffer.putShort(offset + 0, (short) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int numInGroupEncodingOffset() {
    return 2;
  }

  public static int numInGroupEncodingLength() {
    return 2;
  }

  public static int numInGroupNullValue() {
    return 65535;
  }

  public static int numInGroupMinValue() {
    return 0;
  }

  public static int numInGroupMaxValue() {
    return 65534;
  }

  public GroupSizeEncodingEncoder numInGroup(final int value) {
    buffer.putShort(offset + 2, (short) value, java.nio.ByteOrder.LITTLE_ENDIAN);
    return this;
  }

  public static int numGroupsEncodingOffset() {
    return 4;
  }

  public static int numGroupsEncodingLength() {
    return 0;
  }

  public static int numGroupsNullValue() {
    return 65535;
  }

  public static int numGroupsMinValue() {
    return 0;
  }

  public static int numGroupsMaxValue() {
    return 65534;
  }

  public int numGroups() {
    return 1;
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

    final GroupSizeEncodingDecoder decoder = new GroupSizeEncodingDecoder();
    decoder.wrap(buffer, offset);

    return decoder.appendTo(builder);
  }
}
