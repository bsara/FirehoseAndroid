package com.mysterioustrousers.firehose.chat;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum ChatBoxAppearanceType {
  BOTTOM_EDGE,
  POPUP;



  public static ChatBoxAppearanceType parseString(String str) {
    return StringEnumUtils.parseString(ChatBoxAppearanceType.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}