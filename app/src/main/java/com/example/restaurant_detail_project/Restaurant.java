package com.example.restaurant_detail_project;

public class Restaurant {
    private String name;
    private String location;
    private String phoneNumber;
    private String description;

    public Restaurant(String name, String location, String phoneNumber, String description) {
        this.name = name;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.description = description;
    }

    // Getter methods for the fields

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDescription() {
        return description;
    }
}
