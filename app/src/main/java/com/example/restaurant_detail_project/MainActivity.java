package com.example.restaurant_detail_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

        RecyclerView recyclerViewRestaurants;
        RestaurantAdapter restaurantAdapter;
        ArrayList<Restaurant> restaurantList;
        Button btnAddRestaurant;

        // Key for storing restaurant data in SharedPreferences
        public static final String PREFS_NAME = "RestaurantPrefs";
        public static final String RESTAURANT_LIST_KEY = "restaurantList";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                // Initialize views
                recyclerViewRestaurants = findViewById(R.id.recyclerViewRestaurants);
                btnAddRestaurant = findViewById(R.id.btnAddRestaurant);

                // Load restaurant data from SharedPreferences
                restaurantList = loadRestaurantData();

                // Set up RecyclerView
                recyclerViewRestaurants.setHasFixedSize(true);
                recyclerViewRestaurants.setLayoutManager(new LinearLayoutManager(this));
                restaurantAdapter = new RestaurantAdapter(this, restaurantList);
                recyclerViewRestaurants.setAdapter(restaurantAdapter);

                // Set onClickListener for Add Restaurant button
                btnAddRestaurant.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                                // Launch the AddRestaurantActivity
                                Intent intent = new Intent(MainActivity.this,AddRestaurantActivity.class);
                                startActivityForResult(intent, 1);
                        }
                });
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == 1) {
                        if (resultCode == RESULT_OK) {
                                // Get restaurant data from AddRestaurantActivity
                                String name = data.getStringExtra("name");
                                String location = data.getStringExtra("location");
                                String phoneNumber = data.getStringExtra("phoneNumber");
                                String description = data.getStringExtra("description");

                                // Create new restaurant object
                                Restaurant newRestaurant = new Restaurant(name, location, phoneNumber, description);

                                // Add restaurant to list
                                restaurantList.add(newRestaurant);
                                restaurantAdapter.notifyDataSetChanged();

                                // Save updated restaurant data to SharedPreferences
                                saveRestaurantData(restaurantList);
                        }
                }
        }

        private ArrayList<Restaurant> loadRestaurantData() {
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                Gson gson = new Gson();
                String json = sharedPreferences.getString(RESTAURANT_LIST_KEY, null);
                if (json == null){
                        return new ArrayList<>();
                }
                Type type = new TypeToken<ArrayList<Restaurant>>() {}.getType();
                return gson.fromJson(json, type);
        }

        private void saveRestaurantData(ArrayList<Restaurant> restaurantList) {
                SharedPreferences sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(restaurantList);
                editor.putString(RESTAURANT_LIST_KEY, json);
                editor.apply();
        }
}
