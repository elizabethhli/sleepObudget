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

public class DrinksPage extends AppCompatActivity {

    ListView drinkList;
    CustomAdapter customAdapter;
    Button back;
    String email;
    public static double fullPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks_page);

        drinkList = findViewById(R.id.roommates_list);

        Button cart = findViewById(R.id.checkout);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DrinksPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        ArrayList<String> drinks = new ArrayList<String>() {{
            add("Coke");
            add("Sprite");
            add("Nestea");
            add("Apple juice");
            add("Orange juice");
            add("Chocolate milk");
        }};

        ArrayList<String> pDrinks = new ArrayList<String>() {{
            add("3.97");
            add("3.97");
            add("2.47");
            add("1.95");
            add("2.64");
            add("3.27");
        }};

        customAdapter = new CustomAdapter(drinks, pDrinks, DrinksPage.this);
        drinkList.setAdapter(customAdapter);

        drinkList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(DrinksPage.this);
                boolean insert = db.insertFoodDrinks(email, drinks.get(position), pDrinks.get(position), "1");
                fullPrice = Double.parseDouble(pDrinks.get(position));
                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(DrinksPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(drinks.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                        fullPrice = fullPrice * Double.parseDouble(((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(drinks.get(position));
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
                Intent intent = new Intent(DrinksPage.this, SleepoverChoicePage.class);
                startActivity(intent);
            }
        });
    }
    public static double getPrice(){
        return fullPrice;
    }
}
