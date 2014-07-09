package com.mysterioustrousers.firehose;



import com.mysterioustrousers.lang.StringUtils;



public enum BoxState {
  NONE,
  OPEN,
  CHATTING,
  DISCONNECTED;


  public static BoxState parse(String boxStateStr) {
    if (StringUtils.isNullOrWhiteSpace(boxStateStr)) {
      return null;
    }

    String boxStateStrTemp = boxStateStr.trim().toLowerCase();

    if (boxStateStrTemp.equals(BoxState.NONE.toString())) {
      return BoxState.NONE;
    }
    if (boxStateStrTemp.equals(BoxState.OPEN.toString())) {
      return BoxState.OPEN;
    }
    if (boxStateStrTemp.equals(BoxState.CHATTING.toString())) {
      return BoxState.CHATTING;
    }
    if (boxStateStrTemp.equals(BoxState.DISCONNECTED.toString())) {
      return BoxState.DISCONNECTED;
    }
    return null;
  }


  public String toString() {
    switch (this) {
      case NONE:
        return "none";
      case OPEN:
        return "open";
      case CHATTING:
        return "chatting";
      case DISCONNECTED:
        return "disconnected";
    }
    return null;
  }
}