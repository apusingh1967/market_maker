/* Generated SBE (Simple Binary Encoding) message codec. */
package com.codingmonster.common.sbe;

@SuppressWarnings("all")
public enum Side {
  Buy((short) 1),

  Sell((short) 2),

  /** To be used to represent not present or null. */
  NULL_VAL((short) 255);

  private final short value;

  Side(final short value) {
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
  public static Side get(final short value) {
    switch (value) {
      case 1:
        return Buy;
      case 2:
        return Sell;
      case 255:
        return NULL_VAL;
    }

    throw new IllegalArgumentException("Unknown value: " + value);
  }
}
