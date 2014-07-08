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
 * A request for retrieving a {@link JSONObject} response body at a given URL, allowing for an
 * optional {@link JSONObject} to be passed in as part of the request body.
 */
public class GsonRequest<T> extends JsonRequest<T> {

  private final Gson gson = new Gson();
  private final Class<T> clazz;
  private Map<String, String> headers = null;


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
  public GsonRequest(int method, String url, Class<T> clazz, JSONObject jsonRequest,
                     Listener<T> listener, ErrorListener errorListener) {
    super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
          errorListener);
    this.clazz = clazz;
  }


  public GsonRequest(int method, String url, Class<T> clazz, Map<String, String> headers, JSONObject jsonRequest,
                     Listener<T> listener, ErrorListener errorListener) {
    super(method, url, (jsonRequest == null) ? null : jsonRequest.toString(), listener,
          errorListener);
    this.clazz = clazz;
    this.headers = headers;
  }


  @Override
  public Map<String, String> getHeaders() throws AuthFailureError {
    return (this.headers == null) ? new HashMap<String, String>() : this.headers;
  }


  @Override
  protected Response<T> parseNetworkResponse(NetworkResponse response) {
    try {
      String json = new String(
          response.data, HttpHeaderParser.parseCharset(response.headers));
      return Response.success(
          gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
    } catch (UnsupportedEncodingException e) {
      return Response.error(new ParseError(e));
    } catch (JsonSyntaxException e) {
      return Response.error(new ParseError(e));
    }
  }
}
/*
- (void)authorize
        {
        [self sendEvent:FHSChatSocketEventAuthorize
        payload:@{
@"product_tokens"     : @[ self.product.token ],
@"agent_access_token" : [FHAgent loggedInAgent].accessToken,
@"agent_id"           : [FHAgent loggedInAgent].identifier
        }];
        }
        */
