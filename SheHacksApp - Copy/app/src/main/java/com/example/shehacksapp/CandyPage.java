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

public class CandyPage extends AppCompatActivity {
    ListView candyList;
    CustomAdapter customAdapter;
    Button back;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candy_page);

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        Button cart = findViewById(R.id.checkout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CandyPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });

        candyList = findViewById(R.id.roommates_list);
        ArrayList<String> candy = new ArrayList<String>() {{
            add("Sour Keys");
            add("Sour Patch Kids");
            add("KitKat");
            add("Coffee Crisp");
            add("Skittles");
            add("Mike Ike");
            add("Jolly Ranchers");
        }};

        ArrayList<String> pCandy = new ArrayList<String>() {{
            add("8.29");
            add("2.97");
            add("2.00");
            add("2.00");
            add("1.00");
            add("1.00");
            add("1.97");
        }};

        customAdapter = new CustomAdapter(candy, pCandy,CandyPage.this);
        candyList.setAdapter(customAdapter);

        candyList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(CandyPage.this);
                boolean insert = db.insertFoodDrinks(email, candy.get(position), pCandy.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(CandyPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(candy.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(candy.get(position));
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
                Intent intent = new Intent(CandyPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });
    }
}