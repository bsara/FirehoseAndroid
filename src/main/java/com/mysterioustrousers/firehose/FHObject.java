package com.mysterioustrousers.firehose;



import java.util.UUID;

import com.google.gson.annotations.SerializedName;



public class FHObject {

  @SerializedName("id")
  public Object id;

  @SerializedName("created_at")
  public String createdAt;



  protected FHObject() {
    this.setId(-1);
    this.setCreatedAt(null);
  }



  // region: Getters & Setters


  public Object getId() {
    return this.id;
  }


  public void setId(Object id) {
    this.id = id;
  }


  public String getCreatedAt() {
    return this.createdAt;
  }


  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }


  // endregion


  public FHObject initWithObjectIdentifier(String identifier) {
    // TODO some way of caching
    // self = [self init];
    this.id = identifier;
    return this;
  }

    /*
  public static FHObject objectWithIdentifier(Object identifier) {
    static dispatch_once_t onceToken;
    dispatch_once(&onceToken, ^{
        __cachedObjects = [NSMutableArray array];
    });

    // if it has an identifier, look if it's already in the cache
    if (identifier) {
        for (FHObject *object in __cachedObjects) {
            if (object.identifier && [object isKindOfClass:self] && [object isIdentifierEqualTo:identifier]) {
                return object;
            }
        }
    }

    FHObject *object = [[self alloc] initWithObjectIdentifier:identifier];

    return object;
  }
*/



  protected static String generatedUUID() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }
}