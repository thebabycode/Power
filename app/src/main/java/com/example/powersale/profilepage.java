package com.example.powersale;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profilepage extends AppCompatActivity {
    private CheckBox checkBoxVisibility;
    private TextView text, name, email;
    ImageButton edit_btn;

    SharedPreferences sharedPreferences;
    private static final String shared_pref_name = "mypref";
    private static final String key_name = "name";
    private static final String key_mail = "mail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);


        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        sharedPreferences =getSharedPreferences(shared_pref_name, MODE_PRIVATE);
        String uname = sharedPreferences.getString(key_name,null);
        String mail = sharedPreferences.getString(key_mail,null);

        if(uname != null || mail != null )
        {
            // so set the data on text view
            name.setText("Name : "+uname);
            email.setText("Email  : "+mail);
        }


        text = findViewById(R.id.tokens_balance);
        checkBoxVisibility = findViewById(R.id.checkbox);
        boolean isChecked =checkBoxVisibility.isChecked();
        updateTextVisibility(isChecked);
        checkBoxVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                updateTextVisibility(isChecked);
            }
        });

        edit_btn = findViewById(R.id.edit_btn);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(profilepage.this, editprofile.class);
                startActivity(i);
            }
        });
    }



    private void updateTextVisibility(boolean isChecked) {
        if(isChecked) {
            text.setVisibility(View.VISIBLE);
        }
        else {
            text.setVisibility(View.INVISIBLE);
        }
    }
}
