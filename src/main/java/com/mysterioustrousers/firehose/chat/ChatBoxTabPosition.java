package com.mysterioustrousers.firehose.chat;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum ChatBoxTabPosition {
  RIGHT,
  MIDDLE,
  LEFT;



  public static ChatBoxTabPosition parseString(String str) {
    return StringEnumUtils.parseString(ChatBoxTabPosition.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}