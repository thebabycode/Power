package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class editprofile extends AppCompatActivity {

    Button save_btn;
    EditText newname, newmail;
    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "mypref";
    private static final String key_name = "name";
    private static final String key_mail = "mail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);

        save_btn = findViewById(R.id.save_btn);
        newname = findViewById(R.id.newname);
        newmail = findViewById(R.id.newmail);

        sharedPreferences =getSharedPreferences(shared_pref_name, MODE_PRIVATE);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(key_name,newname.getText().toString());
                editor.putString(key_mail,newmail.getText().toString());
                editor.apply();
                Intent i = new Intent(editprofile.this,profilepage.class);
                startActivity(i);
            }
        });
    }
}