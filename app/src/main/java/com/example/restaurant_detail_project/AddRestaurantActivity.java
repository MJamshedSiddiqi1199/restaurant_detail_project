package com.example.restaurant_detail_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class AddRestaurantActivity extends AppCompatActivity {

    private EditText editTextName, editTextLocation, editTextPhoneNumber, editTextDescription;
    private Button buttonAddRestaurant;
//    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        // Initialize SharedPreferences
//        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        editTextName = findViewById(R.id.editTextName);
        editTextLocation = findViewById(R.id.editTextLocation);
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextDescription = findViewById(R.id.editTextDescription);
        buttonAddRestaurant = findViewById(R.id.buttonAddRestaurant);

        buttonAddRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Retrieve the entered information
                String name = editTextName.getText().toString();
                String location = editTextLocation.getText().toString();
                String phoneNumber = editTextPhoneNumber.getText().toString();
                String description = editTextDescription.getText().toString();

                // Validate if all fields are filled
                if (name.isEmpty() || location.isEmpty() || phoneNumber.isEmpty() || description.isEmpty()) {
                    Toast.makeText(AddRestaurantActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Create a new intent to send back the restaurant data
                    Intent intent = new Intent();
                    intent.putExtra("name", name);
                    intent.putExtra("location", location);
                    intent.putExtra("phoneNumber", phoneNumber);
                    intent.putExtra("description", description);

                    // Set the result to OK and pass the intent back
                    setResult(Activity.RESULT_OK, intent);

                    // Finish the activity
                    finish();
                }
            }
        });
    }
}
