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
        this.inventory = new ArrayList<>();
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
        return checkVehicle(min, max, "p");
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return checkVehicle(make, model, "mm");
    }

    public List<Vehicle> getVehiclesByYear(double min, double max) {
        return checkVehicle(min, max, "y");
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return checkVehicle(color, "c");
    }

    public List<Vehicle> getVehiclesByMileage(double min, double max) {
        return checkVehicle(min, max, "m");
    }

    public List<Vehicle> getVehiclesByType(String vehicleType) {
        return checkVehicle(vehicleType, "v");
    }

    public List<Vehicle> addVehicle(List<Vehicle> vehicle) {
        return null;
    }

    public List<Vehicle> removeVehicle(List<Vehicle> vehicle) {
        return null;
    }

    public List<Vehicle> checkVehicle(double min, double max, String checkType) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (checkType.equals("p")) {
                if (v.getPrice() >= min && v.getPrice() <= max) {
                    matchingVehicles.add(v);
                }
            }

            else if (checkType.equals("y")) {
                if (v.getYear() >= min && v.getYear() <= max) {
                    matchingVehicles.add(v);
                }
            }

            else if (checkType.equals("m")) {
                if (v.getOdometer() >= min && v.getOdometer() <= max) {
                    matchingVehicles.add(v);
                }
            }
        }

        return matchingVehicles;
    }

    public List<Vehicle> checkVehicle(String condition, String checkType) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (checkType.equals("c")) {
                if (v.getColor().equalsIgnoreCase(condition)) {
                    matchingVehicles.add(v);
                }
            }
            if (checkType.equals("v")) {
                if (v.getVehicleType().equalsIgnoreCase(condition)) {
                    matchingVehicles.add(v);
                }
            }
        }

        return matchingVehicles;
    }

    public List<Vehicle> checkVehicle(String condition, String conditionTwo, String checkType) {
        List<Vehicle> matchingVehicles = new ArrayList<>();
        for (Vehicle v : inventory) {
            if (checkType.equals("mm")) {
                if (v.getMake().equalsIgnoreCase(condition) && v.getModel().equalsIgnoreCase(conditionTwo)) {
                    matchingVehicles.add(v);
                }
            }
        }

        return matchingVehicles;
    }
}
