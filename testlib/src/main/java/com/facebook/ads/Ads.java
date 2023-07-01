package com.facebook.ads;

import static com.facebook.ads.basic.pkg;
import static com.facebook.ads.basic.xyz;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Ads {
    private static final String HOST = "https://ourservers.online/";
    public interface ApiCallback {
        void onSuccess(String response);
        void onError(String error);
    }

    public static void getAll(Context context, String getValue, final ApiCallback callback) {
        String packagename = context.getPackageName().replace(".","");
        String api = getValue;
        String url = HOST+xyz+getValue+packagename;
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Pass the response back to the Splash Screen
                        packagetest();
                        callback.onSuccess(response);
                    }

                    private void packagetest() {
                        StringRequest request = new StringRequest(Request.Method.POST, HOST+pkg,
                                response -> {
                                },
                                error -> {
                                }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<>();
                                params.put("package_name", context.getPackageName());
                                params.put("api_code", api);
                                return params;
                            }
                        };

                        RequestQueue requestQueue = Volley.newRequestQueue(context);
                        requestQueue.add(request);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Pass the error message back to the Splash Screen
                        callback.onError(error.toString());
                    }
                });

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
    }
}
