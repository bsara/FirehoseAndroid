package com.mysterioustrousers.firehose.net;



import java.util.HashMap;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.mysterioustrousers.firehose.FHApplication;

import org.json.JSONObject;



public class FHClientOptions {

  private FHApplication _app;
  private String        _urlPath;
  private boolean       _useRemoteEnvInstance;

  private RequestQueue            _requestQueue;
  private HashMap<String, String> _headers;
  private JSONObject              _json;

  private Response.Listener      _responseNoErrorListener;
  private Response.ErrorListener _responseErrorListener;



  public FHClientOptions(FHApplication application) {
    this(application, null);
  }


  public FHClientOptions(FHApplication application, String urlPath) {
    this(application, urlPath, false);
  }


  public FHClientOptions(FHApplication application, String urlPath, boolean useRemoteEnvironmentInstance) {
    if (application == null) {
      throw new IllegalArgumentException("application cannot be null!");
    }

    this.setApplication(application);
    this.setURLPath(urlPath);
    this.setUseRemoteEnvironmentInstance(useRemoteEnvironmentInstance);

    this.setRequestQueue(null);
    this.setJSON(null);

    this.setResponseNoErrorListener(null);
    this.setResponseErrorListener(null);

    _headers = new HashMap<String, String>();
  }



  // region Getters/Setters


  public FHApplication getApplication() {
    return _app;
  }


  public void setApplication(FHApplication application) {
    _app = application;
  }


  public String getURLPath() {
    return _urlPath;
  }


  public void setURLPath(String urlPath) {
    _urlPath = urlPath;
  }


  public boolean useRemoteEnvironmentInstance() {
    return _useRemoteEnvInstance;
  }


  public void setUseRemoteEnvironmentInstance(boolean useRemoteEnvironmentInstance) {
    _useRemoteEnvInstance = useRemoteEnvironmentInstance;
  }


  public RequestQueue getRequestQueue() {
    return _requestQueue;
  }


  public void setRequestQueue(RequestQueue requestQueue) {
    _requestQueue = requestQueue;
  }


  public HashMap<String, String> getHeaders() {
    return _headers;
  }


  public void addHeader(String key, String value) {
    _headers.put(key, value);
  }


  public void removeHeader(String key) {
    _headers.remove(key);
  }


  public JSONObject getJSON() {
    return _json;
  }


  public void setJSON(JSONObject json) {
    _json = json;
  }


  public Response.Listener getResponseNoErrorListener() {
    return _responseNoErrorListener;
  }


  public void setResponseNoErrorListener(Response.Listener listener) {
    if (listener == null) {
      _responseNoErrorListener = new Response.Listener<Object>() {
        @Override
        public void onResponse(Object response) {
          // Intentionally doing nothing (a NullPointerException is thrown if a null Listener is given).
        }
      };
      return;
    }
    _responseNoErrorListener = listener;
  }


  public Response.ErrorListener getResponseErrorListener() {
    return _responseErrorListener;
  }


  public void setResponseErrorListener(Response.ErrorListener listener) {
    if (listener == null) {
      _responseErrorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
          // Intentionally doing nothing (a NullPointerException is thrown if a null Listener is given).
        }
      };
      return;
    }
    _responseErrorListener = listener;
  }


  // endregion
}