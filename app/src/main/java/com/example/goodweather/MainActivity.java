package com.example.goodweather;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.goodweather.Class.HttpQuery;
import com.example.goodweather.Class.StubLoader;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String WEATHER_KEY = "001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null && savedInstanceState.containsKey(WEATHER_KEY)) {
            //можно получить объект и прогрузить его
        }
        else{
            //получить данные если грузится первый раз
        }

        try {
            JSONObject object = HttpQuery.Get("https://yandex.ru/pogoda/innopolis");
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // handle new configuration
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(WEATHER_KEY, "001");
    }

}
