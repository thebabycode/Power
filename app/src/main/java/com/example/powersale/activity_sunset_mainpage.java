package com.example.powersale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;


public class activity_sunset_mainpage extends AppCompatActivity {

    ImageButton snst1_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sunset_mainpage);

        snst1_btn = (ImageButton) findViewById(R.id.snst1_btn);

        snst1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(activity_sunset_mainpage.this, activity_snst1_page.class);
                startActivity(i);
            }
        });
    }
}
