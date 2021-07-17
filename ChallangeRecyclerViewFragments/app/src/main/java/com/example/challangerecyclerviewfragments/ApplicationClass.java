package com.example.challangerecyclerviewfragments;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClass extends Application {

    public static List<Car> cars;

    @Override
    public void onCreate() {
        super.onCreate();
        cars = new ArrayList<Car>();
        cars.add(new Car("Volkswagen", "Polo", "Chuck Norris", "987654321"));
        cars.add(new Car("Mercedes", "E200", "Peter Pollack", "123456789"));
        cars.add(new Car("Nissan", "sunny", "John Rambo", "678912345"));
        cars.add(new Car("Mercedes", "S200", "Peter Pollack", "123456789"));
        cars.add(new Car("Volkswagen", "Tiguan", "Chuck Norris", "987654321"));

    }
}
