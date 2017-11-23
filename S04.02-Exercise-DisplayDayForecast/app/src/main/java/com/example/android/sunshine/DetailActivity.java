package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";
    private String mWeatherString;
    private TextView mWeatherTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mWeatherTextView = (TextView) findViewById(R.id.tv_display_weather);

        Intent intent = getIntent();

        if(intent!=null&&intent.hasExtra(Intent.EXTRA_TEXT)){
            mWeatherString = intent.getStringExtra(Intent.EXTRA_TEXT);
            mWeatherTextView.setText(mWeatherString);
        }

        // TODO (2) Display the weather forecast that was passed from MainActivity
    }
}