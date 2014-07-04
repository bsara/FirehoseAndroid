package com.mysterioustrousers.firehose.net;



import com.mysterioustrousers.firehose.FHApplication;



public class FHClient {

  // region: Singleton Implementation

  private static FHClient s_instance = null;


  public static FHClient getInstance() {
    if (s_instance == null) {
      s_instance = new FHClient();
    }
    return s_instance;
  }

  // endregion



  private FHClient() {}



  public void get(FHApplication server) {
    // TODO: Implement
  }


  public void post(FHApplication server) {
    // TODO: Implement
  }


  public void put(FHApplication server) {
    // TODO: Implement
  }


  public void delete(FHApplication server) {
    // TODO: Implement
  }


  private void sendRequest(FHApplication server) {
    // TODO: Implement
  }
}