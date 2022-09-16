package com.example.powersale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerview_adapter extends RecyclerView.Adapter<recyclerview_adapter.MyViewHolder>{

    Context context;
    ArrayList<car_model> carModels;

    public recyclerview_adapter(Context context, ArrayList<car_model> carModels)
    {
        this.context = context;
        this.carModels = carModels;
    }

    @NonNull
    @Override
    public recyclerview_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the Layout(Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row,parent, false);
        return new recyclerview_adapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerview_adapter.MyViewHolder holder, int position) {

        holder.cName.setText(carModels.get(position).getCarname());
        holder.cMileage.setText(carModels.get(position).getMileage());
        holder.cPrice.setText(carModels.get(position).getPrice());
        holder.imageView.setImageResource(carModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return carModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView cName, cMileage, cPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.carimage);
            cName = itemView.findViewById(R.id.carname);
            cPrice = itemView.findViewById(R.id.carprice);
            cMileage = itemView.findViewById(R.id.carmileage);
        }
    }
}
