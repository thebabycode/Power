package com.example.powersale;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cars_mainpage extends AppCompatActivity implements RecyclerViewInterface{

    ArrayList<car_model> carModels = new ArrayList<>();
    int[] carImages = {R.drawable.car1,R.drawable.car2,R.drawable.car3,R.drawable.car4,R.drawable.car5,
            R.drawable.car6,R.drawable.car7,R.drawable.car8,R.drawable.car9,R.drawable.car10};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cars_mainpage);

        RecyclerView recyclerView = findViewById(R.id.car_recyclerview);

        setupcarmodels();

        recyclerview_adapter adapter = new recyclerview_adapter(this,carModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupcarmodels(){
        String[] carnames = getResources().getStringArray(R.array.carlist_name);
        String[] mileage = getResources().getStringArray(R.array.carlist_mileage);
        String[] carprice = getResources().getStringArray(R.array.carlist_price);


        for(int i = 0; i<carnames.length; i++)
        {
            carModels.add(new car_model(carImages[i], carnames[i], mileage[i], carprice[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(cars_mainpage.this, car_itempage.class);

        i.putExtra("Name",carModels.get(position).getCarname());
        i.putExtra("Mileage",carModels.get(position).getMileage());
        i.putExtra("Price",carModels.get(position).getPrice());
        i.putExtra("Image",carModels.get(position).getImage());

        startActivity(i);
    }
}
