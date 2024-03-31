package com.example.restaurant_detail_project;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

            // Set click listeners for WhatsApp and Message icons
            ivWhatsApp.setOnClickListener(this);
            ivMessage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Restaurant restaurant = restaurantList.get(position);

            if (v.getId() == R.id.ivWhatsApp) {
                // Handle WhatsApp click
                // Example: Open WhatsApp with a specific phone number
                openWhatsApp(restaurant.getPhoneNumber());
            } else if (v.getId() == R.id.ivMessage) {
                // Handle Message click
                // Example: Open messaging app with a specific phone number
                openMessagingApp(restaurant.getPhoneNumber());
            }
        }


        // Method to open WhatsApp with a specific phone number
        private void openWhatsApp(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            String url = "https://api.whatsapp.com/send?phone=" + phoneNumber;
            intent.setData(Uri.parse(url));
            context.startActivity(intent);
        }

        // Method to open messaging app with a specific phone number
        private void openMessagingApp(String phoneNumber) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:" + phoneNumber));
            context.startActivity(intent);
        }
    }
}
