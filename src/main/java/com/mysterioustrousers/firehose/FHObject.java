package com.mysterioustrousers.firehose;



import java.util.Comparator;
import java.util.Date;
import java.util.UUID;

import com.google.gson.annotations.SerializedName;



public abstract class FHObject {

  @SerializedName("id")
  private Object _id;

  @SerializedName("created_at")
  private Date _createdAt; // TODO: maybe make a calendar, but gson seems to only work with Date



  protected FHObject() {
    this.setId(null);
    this.setCreatedAt(null);
  }



  protected static String generatedUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }



  // region: Getters & Setters


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



  // region Comparator Getters


  public static <T extends FHObject> Comparator<T> getDefaultComparator() {
    return new Comparator<T>() {
      @Override
      public int compare(FHObject lhs, FHObject rhs) {
        int commonCompareOpersResult = FHObject.runCommonCompareOperations(lhs, rhs);

        if (commonCompareOpersResult != -2) {
          return commonCompareOpersResult;
        }

        return lhs.getCreatedAt().compareTo(rhs.getCreatedAt());
      }
    };
  }


  protected static int runCommonCompareOperations(FHObject lhs, FHObject rhs) {
    if (lhs == null && rhs != null) {
      return -1;
    }
    if (lhs != null && rhs == null) {
      return 1;
    }
    if (lhs == rhs || lhs.equals(rhs)) {
      return 0;
    }
    return -2;
  }


  // endregion



  @Override
  public int hashCode() {
    return this.getId().hashCode();
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