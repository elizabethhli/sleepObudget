package com.example.shehacksapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class DinnerPage extends AppCompatActivity {
    ListView dinnerList;
    CustomAdapter customAdapter;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner_page);

        dinnerList = findViewById(R.id.roommates_list);

        ArrayList<String> dinner = new ArrayList<String>() {{
            add("Pizza");
            add("Chicken Tacos");
            add("Lasagna");
            add("Mac and Cheese");
            add("Sandwich");
            add("Pasta");
            add("Classic Breakfast");
        }};

        ArrayList<String> pDinner = new ArrayList<String>() {{
            add("10.24");
            add("12.49");
            add("15.74");
            add("16.50");
            add("4.25");
            add("1.48");
            add("12.42");
        }};


        customAdapter = new CustomAdapter(dinner, pDinner,DinnerPage.this);
        dinnerList.setAdapter(customAdapter);

        dinnerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(DinnerPage.this);
                boolean insert = db.insertFoodDrinks(dinner.get(position), pDinner.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(DinnerPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(dinner.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(dinner.get(position));
                        alertDialog.dismiss();
                    }
                });

                if (alertDialog.getWindow() != null) {
                    alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                }
                alertDialog.show();
            }
        });

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DinnerPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });
    }
}