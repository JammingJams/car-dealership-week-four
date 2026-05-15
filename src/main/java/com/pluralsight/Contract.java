package com.pluralsight;

import java.util.ArrayList;

public abstract class Contract {
    protected String date, customerName, customerEmail;
    protected double totalPrice, monthlyPayment;
    protected Vehicle vehicleSold;
    private ArrayList<Contract> contracts;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        this.vehicleSold = vehicleSold;
        this.contracts = new ArrayList<>();
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    public ArrayList<Contract> getContracts() {
        return contracts;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
