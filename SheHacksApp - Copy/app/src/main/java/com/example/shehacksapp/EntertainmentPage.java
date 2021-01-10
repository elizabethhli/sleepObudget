package com.example.shehacksapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EntertainmentPage extends AppCompatActivity {

    ListView entList;
    CustomAdapter customAdapter;
    Button back;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entertainment_page);

        Button cart = findViewById(R.id.checkout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EntertainmentPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        entList = findViewById(R.id.roommates_list);
        ArrayList<String> ent = new ArrayList<String>() {{
            add("Movies");
            add("Karaoke");
            add("Monopoly");
            add("Clue");
            add("The Game of Life");
            add("Settlers of Catan");
            add("Risk");
        }};

        ArrayList<String> pEnt = new ArrayList<String>() {{
            add("15");
            add("50");
            add("20");
            add("25.90");
            add("27.93");
            add("60");
            add("33.98");
        }};

        customAdapter = new CustomAdapter(ent, pEnt,EntertainmentPage.this);
        entList.setAdapter(customAdapter);

        entList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(EntertainmentPage.this);
                boolean insert = db.insertFoodDrinks(email, ent.get(position), pEnt.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(EntertainmentPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(ent.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(ent.get(position));
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
                Intent intent = new Intent(EntertainmentPage.this, SleepoverChoicePage.class);
                startActivity(intent);
            }
        });
    }
}