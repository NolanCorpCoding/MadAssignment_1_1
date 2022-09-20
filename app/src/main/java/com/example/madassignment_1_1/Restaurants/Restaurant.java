package com.example.madassignment_1_1.Restaurants;

public class Restaurant {
    public final int id;
    private String name;
    private String address;
    private final int drawableReference;

    private static int nextId = 0;

    public Restaurant(int pId, String pName, String pAddress, int pDrawableReference){
        this.id = pId;
        this.name = pName;
        this.address = pAddress;
        this.drawableReference = pDrawableReference;

        nextId = pId + 1;
    }

    public Restaurant(String pName, String pAddress, int pDrawableReference){
        this.id = nextId;
        this.name = pName;
        this.address = pAddress;
        this.drawableReference = pDrawableReference;

        nextId++;
    }

    //getters to get/print the information
    public int getId() { return this.id; }
    public String getName() {
        return this.name;
    }
    public String getAddress() { return this.address; }
    public int getDrawableID() {
        return this.drawableReference;
    }

    //do not need setters for id and drawable reference since these will not change after they are initialised
    public void setName(String pName) { this.name = pName; }
    public void setAddress(String pAddress) { this.address = pAddress; }
}
