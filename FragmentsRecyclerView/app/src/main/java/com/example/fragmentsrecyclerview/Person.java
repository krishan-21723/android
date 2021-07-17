package com.example.fragmentsrecyclerview;

public class Person {

    private String name;
    private String telNr;

    public Person(String name, String telNr) {
        this.name = name;
        this.telNr = telNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelNr() {
        return telNr;
    }

    public void setTelNr(String telNr) {
        this.telNr = telNr;
    }
}
