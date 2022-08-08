package com.example.powersale;

//package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
                // view.setBackgroundResource(R.drawable.toast_background_color);
                toast.makeText(MainActivity.this, "Welcome " + username.getText() + " to Powersale!", toast.LENGTH_LONG).show();

                // Toast toast = Toast.makeText(context, text, duration);

//                Toast toast = new Toast(getApplicationContext());
//                toast.setGravity(Gravity.TOP, 0, 30);
//                TextView tv =new TextView(getApplicationContext());
//                tv.setBackgroundColor(Color.GREEN);
//                tv.setTextColor(Color.RED);
//
//                Typeface t= Typeface.create("serif",Typeface.BOLD);
//                tv.setTypeface(t);
//                tv.setPadding(10,10,10,10);
//                tv.setText("Product Added succesfully");
//                toast.setView(tv);
//                toast.show();
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