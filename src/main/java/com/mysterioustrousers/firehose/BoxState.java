package com.mysterioustrousers.firehose;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum BoxState {
  NONE,
  OPEN,
  CHATTING,
  DISCONNECTED;



  public static BoxState parseString(String str) {
    return StringEnumUtils.parseString(BoxState.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}