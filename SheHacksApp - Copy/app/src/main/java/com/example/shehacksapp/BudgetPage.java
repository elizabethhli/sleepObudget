package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BudgetPage extends AppCompatActivity {

    EditText numPeopleE;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_page);

        numPeopleE = findViewById(R.id.numPeeps);
        next = findViewById(R.id.nextB);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numPeople = Integer.parseInt(numPeopleE.getText().toString());
                String text = "Since you have " + numPeople + " in your group, you will receive a starting budget of $" + (25*numPeople + 50);
                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(BudgetPage.this, R.style.AlertDialogTheme);
                    View view = LayoutInflater.from(BudgetPage.this).inflate(
                            R.layout.layout_alert_dialog3, (ConstraintLayout)findViewById(R.id.layoutDialogContainer));
                    builder.setView(view);
                    ((TextView) view.findViewById(R.id.message_text)).setText(text);
                    final android.app.AlertDialog alertDialog = builder.create();
                    view.findViewById(R.id.pos_button).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent (BudgetPage.this, SleepoverChoicePage.class);
                            startActivity(intent);
                        }
                    });
                    if (alertDialog.getWindow() != null){
                        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                    }
                    alertDialog.show();

            }
        });
    }

}