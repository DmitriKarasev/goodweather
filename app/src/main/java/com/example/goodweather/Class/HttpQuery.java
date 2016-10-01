package com.example.goodweather.Class;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

public class HttpQuery {

    public String EncodingString(String main) throws UnsupportedEncodingException {
        String url = URLEncoder.encode(main, "utf-8");
        return url;
    }

    public static JSONObject Get(String getQueryString) throws JSONException, IOException {
        HttpClient hc = new DefaultHttpClient();
        ResponseHandler response = new BasicResponseHandler();
        HttpGet http = new HttpGet(getQueryString);
        //получаем ответ от сервера
        String resp = (String) hc.execute(http, response);
        JSONObject jsonObject = new JSONObject(resp);
        return jsonObject;
    }

    public static JSONObject  Post() throws IOException, JSONException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost http = new HttpPost("http://site.ru/api.php?");
        ArrayList nameValuePairs = new ArrayList(2);
        nameValuePairs.add(new BasicNameValuePair("login", "user1"));
        nameValuePairs.add(new BasicNameValuePair("pswd", "1234"));
        http.setEntity(new UrlEncodedFormEntity(nameValuePairs));
        String response = (String) httpclient.execute(http, new BasicResponseHandler());
        JSONObject jsonObject = new JSONObject(response);
        return jsonObject;
    }
}
