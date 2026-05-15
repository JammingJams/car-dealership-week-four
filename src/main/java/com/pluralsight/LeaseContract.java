package com.pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue, leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
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
        return getVehicleSold().getPrice() * (0.04 / 12) / (1 - ( Math.pow(1 + (0.04 / 12), -36 ) ) );
    }

    @Override
    public double getTotalPrice() {
        setExpectedEndingValue(0.5);
        setLeaseFee(1.07);

        return getVehicleSold().getPrice() * getLeaseFee() * getExpectedEndingValue() * getMonthlyPayment();
    }
}
