package wuan.nixo.com.wuan_android_v2.utils.http;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.builder.OkHttpRequestBuilder;
import com.zhy.http.okhttp.request.PostStringRequest;
import com.zhy.http.okhttp.request.RequestCall;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.MediaType;

/**
 * Created by zhanghongyu on 2018/6/20.
 */

public class PostJsonBuilder extends OkHttpRequestBuilder<PostJsonBuilder> {
    public String json;
    public String url;
    public Object tag = "";
    public Map<String, String> headers;
    public Map<String, String> params = new HashMap<>();


    public PostJsonBuilder url(String url) {
        this.url = url;
        PostJsonBuilder postJsonBuilder = addHeader();
        return postJsonBuilder;
    }

    public PostJsonBuilder json(Map content) {
        Gson gson = new Gson();
        this.json = gson.toJson(content);
        Log.i("Nixo", "-----Json: ----- " + json);
        return this;
    }

    private PostJsonBuilder addHeader() {
        if (this.headers == null) {
            headers = new LinkedHashMap<>();
        }
        headers.put("Accept", "application/json");
        headers.put("Content-Type", "application/json; charset=UTF-8");
        Gson gson = new Gson();
        String header = gson.toJson(headers);
        Log.i("Nixo", "-----Header: ----- " + header);
        return this;
    }

    public PostJsonBuilder tag(Object tag) {
        this.tag = tag;
        return this;
    }

    @Override
    public RequestCall build() {
        return new PostStringRequest(url, tag, params, headers, json, MediaType.parse("application/json; charset=utf-8"), id).build();
    }
}
