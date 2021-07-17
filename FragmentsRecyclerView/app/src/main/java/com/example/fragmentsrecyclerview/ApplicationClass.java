package com.example.fragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ApplicationClass extends Application {

    public static List<Person> people;

    @Override
    public void onCreate() {
        super.onCreate();

        people = new ArrayList<Person>();
        people.add(new Person("John", "5654323453"));
        people.add(new Person("Leonard", "565492922"));
        people.add(new Person("Sheldon", "5659023812"));
        people.add(new Person("Tom", "6659023812"));

    }
}
