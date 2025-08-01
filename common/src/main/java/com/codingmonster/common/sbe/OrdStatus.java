/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

@SuppressWarnings("all")
public enum OrdStatus {
  New((short) 0),

  PartiallyFilled((short) 1),

  Filled((short) 2),

  Canceled((short) 3),

  Rejected((short) 4),

  /** To be used to represent not present or null. */
  NULL_VAL((short) 255);

  private final short value;

  OrdStatus(final short value) {
    this.value = value;
  }

  /**
   * The raw encoded value in the Java type representation.
   *
   * @return the raw value encoded.
   */
  public short value() {
    return value;
  }

  /**
   * Lookup the enum value representing the value.
   *
   * @param value encoded to be looked up.
   * @return the enum value representing the value.
   */
  public static OrdStatus get(final short value) {
    switch (value) {
      case 0:
        return New;
      case 1:
        return PartiallyFilled;
      case 2:
        return Filled;
      case 3:
        return Canceled;
      case 4:
        return Rejected;
      case 255:
        return NULL_VAL;
    }

    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
