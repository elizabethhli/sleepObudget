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

public class VenuePage extends AppCompatActivity {

    ListView venueList;
    CustomAdapter customAdapter;
    Button back;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_page);

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        Button cart = findViewById(R.id.checkout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VenuePage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });

        venueList = findViewById(R.id.roommates_list);
        ArrayList<String> venue = new ArrayList<String>() {{
            add("Hotel");
            add("Tent at Park");
            add("Airbnb");
            add("Own room");
        }};

        ArrayList<String> pVenue = new ArrayList<String>() {{
            add("120");
            add("25");
            add("210");
            add("0");
        }};

        customAdapter = new CustomAdapter(venue, pVenue,VenuePage.this);
        venueList.setAdapter(customAdapter);

        venueList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(VenuePage.this);
                boolean insert = db.insertFoodDrinks(email, venue.get(position), pVenue.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(VenuePage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(venue.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(venue.get(position));
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
                Intent intent = new Intent(VenuePage.this, SleepoverChoicePage.class);
                startActivity(intent);
            }
        });
    }
}