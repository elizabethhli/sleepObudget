package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SleepoverChoicePage extends AppCompatActivity {

    Button food, venue, drinks, entertainment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleepover_choice_page);

        food = findViewById(R.id.foodbutton);
        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SleepoverChoicePage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });
        venue = findViewById(R.id.venuebutton);
        drinks = findViewById(R.id.drinksbutton);
        entertainment = findViewById(R.id.entertainmentbutton);
    }
}