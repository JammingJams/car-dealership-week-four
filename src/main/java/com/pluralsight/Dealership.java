package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name, address, phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
    //Getters and Setters are here!!!
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public ArrayList<Vehicle> getInventory() {return inventory;}
    public void setInventory(ArrayList<Vehicle> inventory) {this.inventory = inventory;}

    //Other methods are here!!!
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return inventory;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return inventory;
    }
    public List<Vehicle> getVehiclesByYear(double min, double max) {
        return inventory;
    }
    public List<Vehicle> getVehiclesByColor(String color) {
        return inventory;
    }
    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        return inventory;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return inventory;
    }
    public void addVehicle(List<Vehicle> vehicle) {

    }
    public void removeVehicle(List<Vehicle> vehicle) {

    }


}
