package com.example.powersale;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        addListenerOnButton();
    }

    public void addListenerOnButton() {
        Button sunsetmainpage_btn = findViewById(R.id.sunsetmainpage_btn);
        ImageButton snst1_btn = findViewById(R.id.snst1_btn);

        sunsetmainpage_btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent i = new Intent(MainActivity2.this, activity_sunset_mainpage.class);
                startActivity(i);
            }
        });

        snst1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity2.this, activity_snst1_page.class);
                startActivity(i);
            }
        });
    }
}