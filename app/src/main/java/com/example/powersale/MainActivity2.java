package com.example.powersale;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView t =(TextView) findViewById(R.id.gdmrnname);
        Intent i=getIntent();
        String str=i.getStringExtra("msg");
        t.setText(str);

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        Button sunsetmainpage_btn = findViewById(R.id.sunsetmainpage_btn);
        ImageButton snst1_btn = findViewById(R.id.snst1_btn);
        FloatingActionButton profile_btn = findViewById(R.id.profile_btn);

        profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity2.this, profilepage.class);
                startActivity(i);
            }
        });

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