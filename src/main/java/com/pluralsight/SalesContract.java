package com.pluralsight;

import java.util.Scanner;

public class SalesContract extends Contract{
    private double salesTaxAmount, recordingFee, processingFee, months;
    private boolean hasFinanceOption;
    public static Scanner sc = new Scanner(System.in);

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.hasFinanceOption = hasFinanceOption;
        this.months = months;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isHasFinanceOption() {
        return hasFinanceOption;
    }

    public void setHasFinanceOption(boolean hasFinanceOption) {
        this.hasFinanceOption = hasFinanceOption;
    }

    public double getMonths() {
        return months;
    }

    public void setMonths(double months) {
        this.months = months;
    }

    @Override
    public double getMonthlyPayment() {
        if (getVehicleSold().getPrice() >= 10000) {
            setSalesTaxAmount(1.0425);
            setMonths(48);
            return getVehicleSold().getPrice() * (0.0425 / 12) / (1 - ( Math.pow(1 + (0.0425 / 12), -getMonths() ) ) );
        }
        setSalesTaxAmount(1.0525);
        setMonths(24);
        return getVehicleSold().getPrice() * (0.0525 / 12) / (1 - ( Math.pow(1 + (0.0525 / 12), -getMonths() ) ) );
    }

    @Override
    public double getTotalPrice() {
        boolean isFinancing = false;
        boolean loop = true;

        getMonthlyPayment();
        setRecordingFee(100);

        if (getVehicleSold().getPrice() < 10000) {
            setProcessingFee(295);
        }
        else {
            setProcessingFee(495);
        }

        while (loop) {
            System.out.print("Do you want financing (Y/N): ");

            switch (sc.nextLine().toLowerCase().trim()) {
                case ("y") -> {
                    isFinancing = true;
                    setHasFinanceOption(true);
                    loop = false;
                }

                case ("n") ->  {
                    loop = false;
                    setHasFinanceOption(false);
                }

                default -> System.out.println("You need to input a Y or an N!");
            }
        }

        if (isFinancing) {
            return ( (getMonthlyPayment() * getMonths())  + getRecordingFee() + getProcessingFee() ) * getSalesTaxAmount();
        }
        return ( (getMonthlyPayment() * getMonths())  + getRecordingFee() + getProcessingFee() ) * getSalesTaxAmount();
    }

    @Override
    public String toString() {
        return String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%b|%.2f", getDate(), getCustomerName(), getCustomerEmail(), getVehicleSold().getVin(),
                getVehicleSold().getYear(), getVehicleSold().getMake(), getVehicleSold().getModel(), getVehicleSold().getVehicleType(), getVehicleSold().getColor(),
                getVehicleSold().getOdometer(), getVehicleSold().getPrice(), getSalesTaxAmount(), getRecordingFee(), getTotalPrice(), isHasFinanceOption(), getMonthlyPayment());
    }
}
