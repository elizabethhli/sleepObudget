package com.example.shehacksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginPage extends Activity {

    ImageView back_arrow;
    TextView forgot_password, help, register;
    Button login;
    EditText email, password;
    DatabaseHelper db;
    public static String email_string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, MainActivity.class);
                startActivity(intent);
            }
        });

        db = new DatabaseHelper(this);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.loginButton2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();
                boolean checkCredentials = db.checkCredentials(emailStr, passwordStr);
                if (emailStr.equals("")) {
                    CustomAlertDialog.openDialogNoTitle(LoginPage.this, LoginPage.this,
                            (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                            "Please enter an email");
                } else if (passwordStr.equals("")) {
                    CustomAlertDialog.openDialogNoTitle(LoginPage.this, LoginPage.this,
                            (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                            "Please enter a password");
                } else {
                    if (checkCredentials) {
                        email_string = email.getText().toString();
                        Intent intent = new Intent(LoginPage.this, SleepoverChoicePage.class);
                        startActivity(intent);
                    } else {
                        boolean emailExists = db.checkEmail(emailStr);
                        if (emailExists) {
                            CustomAlertDialog.openDialogNoTitle(LoginPage.this, LoginPage.this,
                                    (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                                    "No account found\nwith that email.");
                        } else {
                            CustomAlertDialog.openDialogNoTitle(LoginPage.this, LoginPage.this,
                                    (ConstraintLayout) findViewById(R.id.layoutDialogContainer),
                                    "Wrong email or\npassword");
                        }//end else
                    }//end else
                }//end else
            }//end method onClick
        });//end onClickListened

        forgot_password = findViewById(R.id.forgot_password_Text);
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginPage.this, ConfirmEmail.class);
                startActivity(intent);
            }
        });

        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog.openDialog(LoginPage.this, LoginPage.this,
                        (ConstraintLayout)findViewById(R.id.layoutDialogContainer), getResources().getString(R.string.login_message)
                        , "Help");
            }
        });

        register = findViewById(R.id.register2);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (LoginPage.this, SignUpPage.class);
                startActivity(intent);
            }
        });
    }
}