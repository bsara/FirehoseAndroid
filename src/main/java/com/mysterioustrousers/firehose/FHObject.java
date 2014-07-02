package com.mysterioustrousers.firehose;



import java.util.Calendar;

import com.google.gson.annotations.SerializedName;



public class FHObject {

  @SerializedName("id")
  public int id;

  @SerializedName("created_at")
  public Calendar createdAt;



  protected FHObject() {
    this.setId(-1);
    this.setCreatedAt(null);
  }



  // region: Getters & Setters


  public int getId() {
    return this.id;
  }


  public void setId(int id) {
    this.id = id;
  }


  public Calendar getCreatedAt() {
    return this.createdAt;
  }


  public void setCreatedAt(Calendar createdAt) {
    this.createdAt = createdAt;
  }


  // endregion
}