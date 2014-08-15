package com.mysterioustrousers.firehose.net.gson;



import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysterioustrousers.net.gson.DateDeserializer;



public class FHGsonBuilder {

  // region Singleton Implementation

  private static FHGsonBuilder s_instance;
  private        GsonBuilder   _builder;

  // endregion



  private FHGsonBuilder() {
    super();

    _builder = new GsonBuilder().registerTypeAdapter(Date.class, new DateDeserializer());
  }


  public static FHGsonBuilder getInstance() {
    if (s_instance == null) {
      s_instance = new FHGsonBuilder();
    }
    return s_instance;
  }


  public Gson buildNewGson() {
    return _builder.create();
  }
}