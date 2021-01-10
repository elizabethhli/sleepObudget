package com.example.shehacksapp;

import androidx.appcompat.app.AlertDialog;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ChipsPage extends Activity {

    ListView chipsList;
    CustomAdapter customAdapter;
    Button back;
//    ArrayList<Type> obj = new ArrayList<Type>(
//            Arrays.asList(Obj A, Obj B, Obj C, ....so on));
//    ArrayList<double> pChips = {2.97, 2.97, 2.97, 2.97};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chips_page);

        chipsList = findViewById(R.id.roommates_list);

        ArrayList<String> chips = new ArrayList<String>() {{
            add("Ketchup");
            add("All Dressed");
            add("Classic");
            add("BBQ");
        }};

        ArrayList<String> pChips = new ArrayList<String>() {{
            add("2.97");
            add("2.97");
            add("2.97");
            add("2.97");
        }};

        customAdapter = new CustomAdapter(chips, ChipsPage.this);
        chipsList.setAdapter(customAdapter);

        chipsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DatabaseHelper db = new DatabaseHelper(ChipsPage.this);
                boolean insert = db.insertFoodDrinks(chips.get(position), pChips.get(position), "1");

                androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(ChipsPage.this, R.style.AlertDialogTheme);
                final View view2 = getLayoutInflater().inflate(R.layout.layout_alert_dialog_amount, null);
                builder.setView(view2);
                final AlertDialog alertDialog = builder.create();
                view2.findViewById(R.id.pos_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.updateFoodDrink(chips.get(position), ((EditText) view2.findViewById(R.id.roommate_name_edit)).getText().toString());
                        alertDialog.dismiss();
                    }
                });

                view2.findViewById(R.id.neg_button_room).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.deleteFoodDrink(chips.get(position));
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
                Intent intent = new Intent(ChipsPage.this, FoodOptionsPage.class);
                startActivity(intent);
            }
        });
    }

}

