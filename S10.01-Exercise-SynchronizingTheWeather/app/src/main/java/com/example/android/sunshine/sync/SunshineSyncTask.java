package com.example.android.sunshine.sync;

//  COMPLETE (1) Create a class called SunshineSyncTask


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;

import com.example.android.sunshine.data.WeatherContract;
import com.example.android.sunshine.utilities.NetworkUtils;
import com.example.android.sunshine.utilities.OpenWeatherJsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

public class SunshineSyncTask {

    //  COMPLETE (2) Within SunshineSyncTask, create a synchronized public static void method called syncWeather

    synchronized public static void syncWeather (Context context){
        //      COMPLETE (3) Within syncWeather, fetch new weather data
        try {
            URL weatherRequestUrl = NetworkUtils.getUrl(context);
            String jsonWeatherResponse = NetworkUtils.getResponseFromHttpUrl(weatherRequestUrl);

            ContentValues[] weatherValuses = OpenWeatherJsonUtils
                    .getWeatherContentValuesFromJson(context, jsonWeatherResponse);

            //      COMPLETE (4) If we have valid results, delete the old data and insert the new


            if(weatherValuses != null && weatherValuses.length != 0){
                ContentResolver sunsineResolver = context.getContentResolver();

                sunsineResolver.delete(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        null,
                        null);

                sunsineResolver.bulkInsert(
                        WeatherContract.WeatherEntry.CONTENT_URI,
                        weatherValuses);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


