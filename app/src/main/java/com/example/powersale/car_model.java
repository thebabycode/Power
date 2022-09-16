package com.example.powersale;

public class car_model {
    int image;
    String carname;
    String mileage;
    String price;

    public car_model(int image, String carname, String mileage, String price) {
        this.image = image;
        this.carname = carname;
        this.mileage = mileage;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getCarname() {
        return carname;
    }

    public String getMileage() {
        return mileage;
    }

    public String getPrice() {
        return price;
    }
}
