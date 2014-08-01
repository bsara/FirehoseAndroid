package com.mysterioustrousers.firehose;



import com.mysterioustrousers.lang.StringUtils;



public enum CompanyType {
  DESK,
  CHAT;



  public static CompanyType fromString(String companyTypeStr) {
    if (StringUtils.isNullOrWhiteSpace(companyTypeStr)) {
      return null;
    }

    CompanyType.valueOf("");

    String companyTypeStrTemp = companyTypeStr.trim().toLowerCase();
    if (companyTypeStrTemp.equals(CompanyType.DESK.toString())) {
      return CompanyType.DESK;
    }
    if (companyTypeStrTemp.equals(CompanyType.CHAT.toString())) {
      return CompanyType.CHAT;
    }
    return null;
  }


  @Override
  public String toString() {
    switch (this) {
      case DESK:
        return "desk";
      case CHAT:
        return "chat";
    }
    return null;
  }
}
