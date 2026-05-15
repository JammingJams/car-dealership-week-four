package com.pluralsight;

import java.util.Scanner;

public class SalesContract extends Contract{
    private double salesTaxAmount, recordingFee, processingFee;
    private boolean hasFinanceOption;
    public static Scanner sc = new Scanner(System.in);

    public SalesContract(String date, String customerName, String customerEmail, double totalPrice, double monthlyPayment, Vehicle vehicleSold, double salesTaxAmount, double recordingFee, double processingFee, boolean hasFinanceOption) {
        super(date, customerName, customerEmail, totalPrice, monthlyPayment, vehicleSold);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.hasFinanceOption = hasFinanceOption;
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

    @Override
    public double getMonthlyPayment() {
        if (getVehicleSold().getPrice() >= 10000) {
            return 1.0425;
        }
        return 1.0525;
    }

    @Override
    public double getTotalPrice() {
        boolean isFinancing = false;
        boolean loop = true;

        setSalesTaxAmount(1.05);
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
            return ( ( getMonthlyPayment() * getVehicleSold().getPrice() ) + getRecordingFee() + getProcessingFee() ) * getSalesTaxAmount();
        }
        return ( getVehicleSold().getPrice() + getRecordingFee() + getProcessingFee() ) * getSalesTaxAmount();
    }
}
