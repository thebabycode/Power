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

    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<car_model> carModels;

    public recyclerview_adapter(Context context, ArrayList<car_model> carModels, RecyclerViewInterface recyclerViewInterface)
    {
        this.context = context;
        this.carModels = carModels;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public recyclerview_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //This is where you inflate the Layout(Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview_row,parent, false);
        return new recyclerview_adapter.MyViewHolder(view, recyclerViewInterface);
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

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.carimage);
            cName = itemView.findViewById(R.id.carname);
            cPrice = itemView.findViewById(R.id.carprice);
            cMileage = itemView.findViewById(R.id.carmileage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null)
                    {
                        int pos = getAdapterPosition();
                        if(pos != RecyclerView.NO_POSITION)
                        {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
