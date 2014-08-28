package com.mysterioustrousers.firehose.net;



import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.mysterioustrousers.firehose.EnvironmentManager;
import com.mysterioustrousers.firehose.GsonRequest;



public class FHClient {

  // region Singleton Implementation


  private static FHClient s_instance = null;


  public static FHClient getInstance() {
    if (s_instance == null) {
      s_instance = new FHClient();
    }
    return s_instance;
  }


  // endregion



  private RequestQueue _requestQueue;



  private FHClient() {
    _requestQueue = null;
  }



  // region JSON Requests


  public void jsonGet(FHClientOptions options, Class expectedReturnType) {
    this.sendJSONRequest(options, Request.Method.GET, expectedReturnType);
  }


  public void jsonPost(FHClientOptions options) {
    this.sendJSONRequest(options, Request.Method.POST, null);
  }


  public void jsonPut(FHClientOptions options) {
    this.sendJSONRequest(options, Request.Method.PUT, String.class);
  }


  public void jsonDelete(FHClientOptions options) {
    this.sendJSONRequest(options, Request.Method.DELETE, null);
  }


  private void sendJSONRequest(FHClientOptions options, int requestType, Class expectedReturnType) {
    String url = (options.useRemoteEnvironmentInstance() ? EnvironmentManager.getRemoteInstance() : EnvironmentManager.getInstance()).getBaseURL(options.getApplication()) + options.getURLPath();

    if (expectedReturnType == null) {
      expectedReturnType = Object.class;
    }


    GsonRequest gsonReq;

    if (options.getHeaders().isEmpty()) {
      gsonReq = new GsonRequest(requestType, url, expectedReturnType, options.getJSON(), options.getResponseNoErrorListener(), options.getResponseErrorListener());
    } else {
      gsonReq = new GsonRequest(requestType, url, expectedReturnType, options.getHeaders(), options.getJSON(), options.getResponseNoErrorListener(), options.getResponseErrorListener());
    }


    RequestQueue reqQueue = (options.getRequestQueue() == null) ? _requestQueue : options.getRequestQueue();

    if (reqQueue == null) {
      throw new IllegalArgumentException("No RequestQueue was found! Either call FHClient.setGlobalRequestQueue() or provide a RequestQueue in the FHClientOptions given.");
    }

    reqQueue.add(gsonReq);
  }


  // endregion



  // region RequestQueue


  public void setGlobalRequestQueue(RequestQueue requestQueue) {
    _requestQueue = requestQueue;
  }


  public void resetGlobalRequestQueue() {
    _requestQueue = null;
  }


  // endregion
}