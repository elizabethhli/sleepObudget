package com.example.shehacksapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class CartPage extends AppCompatActivity {

    ArrayList<String> name, price, amount;
    DatabaseHelper db;
    CustomAdapter customAdapter;
    ListView items_list;
    String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        if (LoginPage.getEmail() == null || LoginPage.getEmail().equals("")) {
            email = SignUpPage.getEmail();
        } else {
            email = LoginPage.getEmail();
        }

        items_list = findViewById(R.id.items_list);
        name = new ArrayList<>();
        price = new ArrayList<>();
        amount = new ArrayList<>();

        final Cursor cursor = db.getName(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("name");
            name.add(cursor.getString(i));
        }

        final Cursor cursor2 = db.getPrice(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("price");
            price.add(cursor.getString(i));
        }

        final Cursor cursor3 = db.getAmount(email);
        while (cursor.moveToNext()) {
            int i = cursor.getColumnIndexOrThrow("amount");
            amount.add(cursor.getString(i));
        }

        customAdapter = new CustomAdapter(name, price,CartPage.this);
        items_list.setAdapter(customAdapter);

    }
}