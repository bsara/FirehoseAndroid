package com.mysterioustrousers.firehose;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.Map;

public class GsonArrayRequest extends JsonArrayRequest {
    private Map<String, String> headers;

    public GsonArrayRequest(String url, Map<String, String> headers, Response.Listener<JSONArray> listener, Response.ErrorListener errorListener) {
        super(url, listener, errorListener);
        this.headers = headers;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        return this.headers;
    }
}