package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ChangePassword extends AppCompatActivity {

    ImageView back_arrow;
    Button change_pass;
    DatabaseHelper db;
    EditText password, confirmPassword;
    String email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        back_arrow = findViewById(R.id.back_arrow);

        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (ChangePassword.this, LoginPage.class);
                startActivity(intent);
            }
        });

        password = findViewById(R.id.passwordPass);
        confirmPassword = findViewById(R.id.confirmPasswordPass);
        db = new DatabaseHelper(this);

        Intent intent = getIntent();
        email = intent.getStringExtra("EMAIL");

        change_pass = findViewById(R.id.changePasswordButton);
        change_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwordStr = password.getText().toString();
                String confirmPasswordStr = confirmPassword.getText().toString();
                if (passwordStr.equals("")){
                    CustomAlertDialog.openDialogNoTitle(ChangePassword.this, ChangePassword.this,
                            (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                            "Please enter your\nnew password");
                } else if (confirmPasswordStr.equals("")) {
                    CustomAlertDialog.openDialogNoTitle(ChangePassword.this, ChangePassword.this,
                            (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                            "Please confirm your\nnew password");
                } else {
                    if (!passwordStr.equals(confirmPasswordStr)){
                        CustomAlertDialog.openDialogNoTitle(ChangePassword.this, ChangePassword.this,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                                "Passwords do not match");
                    } else {
                        db.changePassword(email, passwordStr);
                        CustomAlertDialog.openDialogNoTitle(ChangePassword.this, ChangePassword.this,
                                (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                                "Password successfully changed!");
                        Intent intent = new Intent (ChangePassword.this, LoginPage.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}
