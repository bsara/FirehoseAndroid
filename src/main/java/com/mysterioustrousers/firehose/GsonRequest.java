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



/**
 * A request for retrieving a {@link JSONObject} response _body at a given URL, allowing for an
 * optional {@link JSONObject} to be passed in as part of the request _body.
 */
public class GsonRequest<T> extends JsonRequest<T> {

  private final Gson _gson = new Gson();
  private final Class<T> _clazz;
  private Map<String, String> _headers = null;



  /**
   * Creates a new request.
   *
   * @param method
   *     the HTTP method to use
   * @param url
   *     URL to fetch the JSON from
   * @param jsonRequest
   *     A {@link JSONObject} to post with the request. Null is allowed and
   *     indicates no parameters will be posted along with request.
   * @param listener
   *     Listener to receive the JSON response
   * @param errorListener
   *     Error listener, or null to ignore errors.
   */
  public GsonRequest(int method, String url, Class<T> clazz, JSONObject jsonRequest, Listener<T> listener, ErrorListener errorListener) {
    super(method, url, ((jsonRequest == null) ? null : jsonRequest.toString()), listener, errorListener);

    _clazz = clazz;
  }


  public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers, JSONObject jsonRequest, Listener<T> listener, ErrorListener errorListener) {
    super(method, url, ((jsonRequest == null) ? null : jsonRequest.toString()), listener, errorListener);

    _clazz = clazz;
    _headers = headers;
  }


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
