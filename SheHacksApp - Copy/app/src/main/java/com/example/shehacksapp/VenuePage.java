package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class VenuePage extends AppCompatActivity {

    String[] venue = {"Hotel", "Tent + Park", "Airbnb", "Own room"};
    float[] vPrice = {120, 25, 210, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_page);
    }
}