package com.example.powersale;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class profilepage extends AppCompatActivity {
    private CheckBox checkBoxVisibility;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilepage);

        checkBoxVisibility = findViewById(R.id.checkbox);
        text = findViewById(R.id.tokens_balance);
        boolean isChecked =checkBoxVisibility.isChecked();
        updateTextVisibility(isChecked);
        checkBoxVisibility.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonview, boolean isChecked) {
                updateTextVisibility(isChecked);
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
