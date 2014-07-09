package com.mysterioustrousers.firehose;



import java.util.UUID;

import com.google.gson.annotations.SerializedName;



public abstract class FHObject {

  @SerializedName("id")
  private Object _id;

  @SerializedName("created_at")
  private String _createdAt; // TODO: Make this a Calendar object rather than a String



  protected FHObject() {
    this.setId(-1);
    this.setCreatedAt(null);
  }


  /*
  public static FHObject createWithId(String id) {
    // Use FHObjectFactory instead of this method!!!!
  }
  */



  protected static String generatedUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }


  @Override
  public boolean equals(Object obj) {
    return (this == obj)
           || (this.getClass() == obj.getClass() && this.getId().equals(((FHObject)obj).getId()));
  }


  // region: Getters & Setters


  public Object getId() {
    return _id;
  }


  public void setId(Object id) {
    _id = id;
  }


  public String getCreatedAt() {
    return _createdAt;
  }


  public void setCreatedAt(String createdAt) {
    _createdAt = createdAt;
  }


  // endregion
}