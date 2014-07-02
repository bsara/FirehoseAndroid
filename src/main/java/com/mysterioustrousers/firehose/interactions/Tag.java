package com.mysterioustrousers.firehose.interactions;



import com.google.gson.annotations.SerializedName;

import com.mysterioustrousers.firehose.FHObject;



public class Tag extends FHObject {

  @SerializedName("label")
  public String label;
}