package com.example.challangerecyclerviewfragments;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarAdaptor extends RecyclerView.Adapter<CarAdaptor.ViewHolder> {

    private List<Car> cars;

    ItemClicked activity;

    public interface ItemClicked {
        void onItemClicked(int index);
    }

    public CarAdaptor(Context context, List<Car> list) {
        cars = list;
        activity = (ItemClicked) context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivMake;
        TextView tvModel, tvOwner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMake = itemView.findViewById(R.id.ivMake);
            tvModel = itemView.findViewById(R.id.tvModel);
            tvOwner = itemView.findViewById(R.id.tvOwner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(cars.indexOf((Car) v.getTag()));
                }
            });
        }
    }

    @NonNull
    @Override
    public CarAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdaptor.ViewHolder holder, int position) {
        holder.itemView.setTag(cars.get(position));

        holder.tvOwner.setText(cars.get(position).getOwnerName());
        holder.tvModel.setText(cars.get(position).getModel());


        if (cars.get(position).getMake().equals("Volkswagen")) {
            holder.ivMake.setImageResource(R.drawable.volkswagen);
        } else if (cars.get(position).getMake().equals("Nissan")) {
            holder.ivMake.setImageResource(R.drawable.nissan);
        } else {
            holder.ivMake.setImageResource(R.drawable.mercedes);
        }
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
