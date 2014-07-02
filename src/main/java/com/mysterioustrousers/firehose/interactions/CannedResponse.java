package com.mysterioustrousers.firehose.interactions;



import com.google.gson.annotations.SerializedName;

import com.mysterioustrousers.firehose.FHObject;



public class CannedResponse extends FHObject {

  @SerializedName("name")
  public String name;

  @SerializedName("shortcut")
  public String shortcut;

  @SerializedName("text")
  public String text;
}
