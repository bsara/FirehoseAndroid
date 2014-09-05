package com.mysterioustrousers.firehose;



import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;



public abstract class FHObject implements Comparable<FHObject> {

  @SerializedName("id")
  private Object _id;

  @SerializedName("created_at")
  private Date _createdAt; // TODO: maybe make a calendar, but gson seems to only work with Date



  protected FHObject() {
    this.setId(null);
    this.setCreatedAt(null);
  }



  protected static String generateUUID() {
    return UUID.randomUUID().toString();
  }



  // region: Getters & Setters


  // FIXME: This shouldn't return an Object, in fact, we should use a generic connected to FHObject to set the value of the object's ID
  public Object getId() {
    return _id;
  }


  public void setId(Object id) {
    _id = id;
  }


  public Date getCreatedAt() {
    return _createdAt;
  }


  public void setCreatedAt(Date createdAt) {
    _createdAt = createdAt;
  }


  // endregion



  @Override
  public int compareTo(FHObject obj) {
    int commonComparisonsResult = this.runCommonComparisons(obj);
    if (commonComparisonsResult != -2) {
      return commonComparisonsResult;
    }
    return this.getCreatedAt().compareTo(obj.getCreatedAt());
  }


  protected int runCommonComparisons(FHObject obj) {
    if (obj == null) {
      return -1;
    }
    if (this.equals(obj)) {
      return 0;
    }
    return -2;
  }


  @Override
  public int hashCode() {
    return (this.getClass().getName() + this.getId()).hashCode();
  }


  @Override
  public boolean equals(Object obj) {
    return obj != null
           && obj instanceof FHObject
           && (this == obj || this.getId().equals(((FHObject)obj).getId()));
  }


  @Override
  public String toString() {
    return String.format("%s (%s)", this.getClass().getSimpleName(), ((this.getId() == null) ? null : this.getId().toString()));
  }
}