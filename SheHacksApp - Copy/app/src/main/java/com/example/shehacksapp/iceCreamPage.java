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

public class iceCreamPage extends AppCompatActivity {

    ListView iceCreamList;
    CustomAdapter customAdapter;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ice_cream_page);

        iceCreamList = findViewById(R.id.roommates_list);
        ArrayList<String> iceCream = new ArrayList<String>() {{
            add("Vanilla");
            add("Chocolate");
            add("Cookies & Cream");
            add("Chocolate Chip Cookie Dough");
        }};

        ArrayList<String> pIceCream = new ArrayList<String>() {{
            add("3.97");
            add("5.97");
            add("3.97");
            add("4.90");
        }};


        customAdapter = new CustomAdapter(iceCream, iceCreamPage.this);
        iceCreamList.setAdapter(customAdapter);

        iceCreamList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(iceCreamPage.this);
                boolean insert = db.insertFoodDrinks(iceCream.get(position), pIceCream.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(iceCreamPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(iceCream.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(iceCream.get(position));
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
                Intent intent = new Intent(iceCreamPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });
    }
}