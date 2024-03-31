package com.example.restaurant_detail_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerViewRestaurants;
        RestaurantAdapter restaurantAdapter;
        ArrayList<Restaurant> restaurantList;
        Button btnAddRestaurant;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Initialize views
                recyclerViewRestaurants = findViewById(R.id.recyclerViewRestaurants);
                btnAddRestaurant = findViewById(R.id.btnAddRestaurant);

                // Initialize restaurant list
                restaurantList = new ArrayList<>();
                restaurantList.add(new Restaurant("Restaurant 1", "Location 1", "123456789", "Description 1"));
                restaurantList.add(new Restaurant("Restaurant 2", "Location 2", "987654321", "Description 2"));

                // Set up RecyclerView
                recyclerViewRestaurants.setHasFixedSize(true);
                recyclerViewRestaurants.setLayoutManager(new LinearLayoutManager(this));
                restaurantAdapter = new RestaurantAdapter(this, restaurantList);
                recyclerViewRestaurants.setAdapter(restaurantAdapter);

                // Set onClickListener for Add Restaurant button
                btnAddRestaurant.setOnClickListener(v -> {
                        // For now, display a toast message
                        Toast.makeText(MainActivity.this, "Add Restaurant Clicked", Toast.LENGTH_SHORT).show();
                });
        }
}
