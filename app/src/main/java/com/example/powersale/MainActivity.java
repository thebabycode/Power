package com.example.powersale;

//package com.example.activitylifecycle;

import static android.text.TextUtils.isEmpty;

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

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private EditText username_txt;
    private Button btn;
    TextView appname;
    private EditText userpswd_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Process Created", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);
        username_txt = (EditText)findViewById(R.id.username);
        userpswd_txt = (EditText)findViewById(R.id.userpswd);
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
                String name = username_txt.getText().toString();
                String pswd = userpswd_txt.getText().toString();
                boolean isValid = true;
                if (isEmpty(name)) {
                    username_txt.setError("You must enter username to login!");
                    isValid = false;
                }
                if (isEmpty(pswd)) {
                    userpswd_txt.setError("You must enter password to login!");
                    isValid = false;
                }

                if(isValid) {
                    if (name.equals(pswd)) {
                        Intent i = new Intent(MainActivity.this, MainActivity2.class);
                        i.putExtra("msg", "Good Morning " + name + "!");
                        startActivity(i);
                    } else {
                        Toast toast = new Toast(getApplicationContext());
                        toast.setGravity(Gravity.TOP, 0, 30);
                        toast.makeText(MainActivity.this, "Incorrect Username/Password! name=" + name + "pswd=" + pswd, toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ImageButton googlelogo_btn = findViewById(R.id.googlelogo_btn);
        ImageButton twitterlogo_btn = findViewById(R.id.twitterlogo_btn);
        ImageButton instagramlogo_btn = findViewById(R.id.instagramlogo_btn);
        ImageButton facebooklogo_btn = findViewById(R.id.facebooklogo_btn);

        googlelogo_btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Uri webpage= Uri.parse("https://www.github.com/thebabycode");
                 Intent web=new Intent(Intent.ACTION_VIEW,webpage);
                 startActivity(web);
             }
        });

        twitterlogo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage= Uri.parse("https://www.twitter.com/");
                Intent web=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(web);
            }
        });

        instagramlogo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage= Uri.parse("https://www.instagram.com/johnsmemana");
                Intent web=new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(web);
            }
        });

        facebooklogo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage= Uri.parse("https://www.facebook.com/");
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