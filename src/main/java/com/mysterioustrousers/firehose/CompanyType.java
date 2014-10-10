package com.mysterioustrousers.firehose;



import com.mysterioustrousers.lang.StringEnumUtils;



public enum CompanyType {
  DESK,
  CHAT;



  public static CompanyType parseString(String str) {
    return StringEnumUtils.parseString(CompanyType.class, str);
  }


  @Override
  public String toString() {
    return StringEnumUtils.toString(this);
  }
}