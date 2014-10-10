package com.mysterioustrousers.firehose.net.gson;



import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysterioustrousers.net.gson.CommonTypeAdapterFactory;
import com.mysterioustrousers.net.gson.DateDeserializer;



public class FHGsonBuilder {

  // region Singleton Implementation


  private static FHGsonBuilder s_instance;


  public static FHGsonBuilder getInstance() {
    if (s_instance == null) {
      s_instance = new FHGsonBuilder();
    }
    return s_instance;
  }


  // endregion



  private GsonBuilder _builder;



  private FHGsonBuilder() {
    super();

    _builder = new GsonBuilder()
        .registerTypeAdapterFactory(new CommonTypeAdapterFactory())
        .registerTypeAdapter(Date.class, new DateDeserializer())
        .serializeNulls();
  }


  public Gson buildNewGson() {
    return _builder.create();
  }
}