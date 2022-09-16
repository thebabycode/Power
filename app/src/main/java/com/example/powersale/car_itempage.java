package com.example.powersale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class car_itempage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_itempage);

        String name = getIntent().getStringExtra("Name");
        int image = getIntent().getIntExtra("Image",0);
        String price = getIntent().getStringExtra("Price");
        String mileage = getIntent().getStringExtra("Mileage");

        TextView tvname = findViewById(R.id.carname);
        TextView tvprice = findViewById(R.id.price_val);
        TextView tvmileage = findViewById(R.id.mileage_val);
        ImageView tvimage = findViewById(R.id.carimage);

        tvname.setText(name);
        tvimage.setImageResource(image);
        tvmileage.setText(mileage);
        tvprice.setText(price);

    }
}