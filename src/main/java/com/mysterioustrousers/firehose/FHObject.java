package com.mysterioustrousers.firehose;



import java.util.Date;

import com.google.gson.annotations.SerializedName;



public class FHObject {

  @SerializedName("id")
  public int id;

  @SerializedName("created_at")
  public Date createdAt;



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


  public Date getCreatedAt() {
    return this.createdAt;
  }


  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }


  // endregion
}