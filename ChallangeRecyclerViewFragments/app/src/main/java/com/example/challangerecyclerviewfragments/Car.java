package com.example.challangerecyclerviewfragments;

public class Car {
    private String make;
    private String model;
    private String ownerName;
    private String ownerTel;

    public Car(String make, String model, String ownerName, String ownerTel) {
        this.make = make;
        this.model = model;
        this.ownerName = ownerName;
        this.ownerTel = ownerTel;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerTel() {
        return ownerTel;
    }

    public void setOwnerTel(String ownerTel) {
        this.ownerTel = ownerTel;
    }
}
