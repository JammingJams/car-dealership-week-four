package com.pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue, leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, double totalPrice, double monthlyPayment, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerEmail, totalPrice, monthlyPayment, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        return 1.04;
    }

    @Override
    public double getTotalPrice() {
        setExpectedEndingValue(0.5);
        setLeaseFee(1.07);

        return getVehicleSold().getPrice() * getLeaseFee() * getExpectedEndingValue() * getMonthlyPayment();
    }
}
