package com.example.shehacks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView tortoise, speech;
    Button bt;
    TextView text1, text2;

    boolean show = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tortoise = findViewById(R.id.imageView1);
        speech = findViewById(R.id.imageView2);
        text1 = findViewById(R.id.textView1);
        text2 = findViewById(R.id.textView2);



        bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (show) {
                    bt.setText("Let's Start");
                    text1.setVisibility(View.INVISIBLE);
                    text2.setVisibility(View.VISIBLE);
                    show = false;
                }
                else {
                    // where you can start the next activity
//                    Intent intent = new Intent(MainActivity.this, IntroductionActivity.class);
//                    startActivity(intent);
                }
            }
        });

    }
}