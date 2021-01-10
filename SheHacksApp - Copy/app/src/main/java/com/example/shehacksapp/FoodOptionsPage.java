package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodOptionsPage extends AppCompatActivity {
    TextView chips, dinner, iceCream, candy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_options_page);

        chips = findViewById(R.id.chips);
        chips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOptionsPage.this, ChipsPage.class);
                startActivity(intent);
            }
        });
        dinner = findViewById(R.id.burger);
        dinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOptionsPage.this, DinnerPage.class);
                startActivity(intent);
            }
        });
        iceCream = findViewById(R.id.icecream);
        iceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOptionsPage.this, iceCreamPage.class);
                startActivity(intent);
            }
        });
        candy = findViewById(R.id.candy);
        candy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FoodOptionsPage.this, CandyPage.class);
                startActivity(intent);
            }
        });
    }
}