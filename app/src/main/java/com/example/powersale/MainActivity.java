package com.example.powersale;

//package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private Button btn;
    TextView appname;
    EditText userpswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Process Created", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        username = (EditText)findViewById(R.id.username);
        userpswd = (EditText)findViewById(R.id.userpswd);
        appname=(TextView)findViewById(R.id.appname);
        addListenerOnButton();

    }

    public void addListenerOnButton()
    {
        btn = (Button) findViewById(R.id.buttonToast);
        btn.setOnClickListener(new View.OnClickListener()
        {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.TOP, 0, 30);
                toast.makeText(MainActivity.this, "Welcome " + username.getText() + " to Powersale!", toast.LENGTH_LONG).show();

            }
        });

        Button mainpg_btn = findViewById(R.id.nextpagebutton);
        mainpg_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }
        });

         ImageButton googlelogo_btn = findViewById(R.id.googlelogo_btn);
         googlelogo_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri webpage= Uri.parse("https://www.google.com/");
                 Intent web=new Intent(Intent.ACTION_VIEW,webpage);
                 startActivity(web);
             }
         });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Process Started", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Process Stopped", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Process Paused", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Process Resumed", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Process Restarted", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Process Destroyed", Toast.LENGTH_SHORT).show();
    }
}