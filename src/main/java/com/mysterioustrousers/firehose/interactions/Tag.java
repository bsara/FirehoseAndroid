package com.mysterioustrousers.firehose.interactions;



import com.google.gson.annotations.SerializedName;

import com.mysterioustrousers.firehose.FHObject;



public class Tag extends FHObject {

  @SerializedName("label")
  private String _label;



  public Tag() {
    super();

    this.setLabel(null);
  }



  // region Getters & Setters


  public String getLabel() {
    return _label;
  }


  public void setLabel(String label) {
    _label = label;
  }


  // endregion
}