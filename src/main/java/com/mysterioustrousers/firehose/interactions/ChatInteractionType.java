package com.mysterioustrousers.firehose.interactions;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum ChatInteractionType {
  CHAT,
  NAVIGATION,
  TYPING;



  public static ChatInteractionType parseString(String str) {
    return StringEnumUtils.parseString(ChatInteractionType.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}