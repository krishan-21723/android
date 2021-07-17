package com.example.recyclerview;

public class Person {

    private String name;
    private String surname;
    private String preference;//bus or plane

    public Person(String name, String surname, String preference) {
        this.name = name;
        this.surname = surname;
        this.preference = preference;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPreference() {
        return preference;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
