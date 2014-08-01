package com.mysterioustrousers.firehose;



import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;



public class GsonArrayRequest extends JsonArrayRequest {

  private Map<String, String> _headers;


  public GsonArrayRequest(String url, Map<String, String> headers, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
    super(url, listener, errorListener);

    _headers = headers;
  }



  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return _headers;
  }
}