package com.example.restaurant_detail_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private ArrayList<Restaurant> restaurantList;
    private Context context;

    public RestaurantAdapter(Context context, ArrayList<Restaurant> restaurantList) {
        this.context = context;
        this.restaurantList = restaurantList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.tvRestaurantName.setText(restaurant.getName());
        holder.tvLocation.setText(restaurant.getLocation());
        holder.tvPhoneNumber.setText(restaurant.getPhoneNumber());
        holder.tvDescription.setText(restaurant.getDescription());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvRestaurantName, tvLocation, tvPhoneNumber, tvDescription;
        ImageView ivWhatsApp, ivMessage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRestaurantName = itemView.findViewById(R.id.tvRestaurantName);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            tvPhoneNumber = itemView.findViewById(R.id.tvPhoneNumber);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivWhatsApp = itemView.findViewById(R.id.ivWhatsApp);
            ivMessage = itemView.findViewById(R.id.ivMessage);
        }
    }
}
