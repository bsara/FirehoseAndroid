package com.mysterioustrousers.firehose;



import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import org.json.JSONObject;



public class GsonRequest<T> extends JsonRequest<T> {

  private final Gson     _gson;
  private final Class<T> _clazz;

  private Map<String, String> _headers;



  // region Constructors


  public GsonRequest(int httpMethod, String url, Class<T> clazz, JSONObject jsonRequest, Listener<T> listener, ErrorListener errorListener) {
    this(httpMethod, url, clazz, null, jsonRequest, listener, errorListener);
  }


  public GsonRequest(int httpMethod, String url, Class<T> clazz, Map<String, String> headers, JSONObject jsonRequest, Listener<T> listener, ErrorListener errorListener) {
    super(httpMethod, url, ((jsonRequest == null) ? null : jsonRequest.toString()), listener, errorListener);

    _gson = new Gson();
    _clazz = clazz;
    _headers = headers;
  }


  // endregion



  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return (_headers == null) ? new HashMap<String, String>() : _headers;
  }


  @Override
  protected Response<T> parseNetworkResponse(NetworkResponse response) {
    try {
      String json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
      return Response.success(_gson.fromJson(json, _clazz), HttpHeaderParser.parseCacheHeaders(response));
    } catch (UnsupportedEncodingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonSyntaxException e) {
      return Response.error(new ParseError(e));
    }
  }
}