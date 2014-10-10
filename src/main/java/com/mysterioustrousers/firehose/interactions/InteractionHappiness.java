package com.mysterioustrousers.firehose.interactions;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum InteractionHappiness {
  UNKNOWN,
  UPSET,
  SATISFIED,
  HAPPY;



  public static ChatInteractionType parseString(String str) {
    return StringEnumUtils.parseString(ChatInteractionType.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}