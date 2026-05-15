package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractDataManager {

    public static ArrayList<Contract> getContractTransaction() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/contract.csv"));
            String line = bufferedReader.readLine();

            ArrayList<Contract> contracts = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {

                String[] tempArray = line.split("\\|");

                try {
                    String contractType = tempArray[0];
                    String date = tempArray[1];
                    String customerName = tempArray[2];
                    String customerEmail = tempArray[3];
                    int vin = Integer.parseInt(tempArray[4]);
                    int year = Integer.parseInt(tempArray[5]);
                    String make = tempArray[6];
                    String model = tempArray[7];
                    String vehicleType = tempArray[8];
                    String color = tempArray[9];
                    int odometer = Integer.parseInt(tempArray[10]);
                    double price = Double.parseDouble(tempArray[11]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    if(contractType.equalsIgnoreCase("Sale")) {
                        double salesTax = Double.parseDouble(tempArray[12]);
                        double recordingFee = Double.parseDouble(tempArray[13]);
                        double totalPrice = Double.parseDouble(tempArray[14]);
                        boolean hasFinanceOption = (tempArray[15].equalsIgnoreCase("yes"));
                        //double monthlyPayment = Double.parseDouble(tempArray[16]);

                        SalesContract salesContract = new SalesContract(date, customerName, customerEmail, vehicle);

                        salesContract.setSalesTaxAmount(salesTax);
                        salesContract.setRecordingFee(recordingFee);
                        salesContract.setHasFinanceOption(hasFinanceOption);
                        contracts.add(salesContract);

                    }

                    else {
                        double expectedEndingValue = Double.parseDouble(tempArray[12]);
                        double leaseFee = Double.parseDouble(tempArray[13]);
                        double totalPrice = Double.parseDouble(tempArray[14]);
                        double monthlyPayment = Double.parseDouble(tempArray[15]);

                        LeaseContract leaseContract = new LeaseContract(date, customerName, customerEmail, vehicle);

                        leaseContract.setExpectedEndingValue(expectedEndingValue);
                        leaseContract.setLeaseFee(leaseFee);
                        contracts.add(leaseContract);

                    }

                }

                catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("SUCCESS!");
            bufferedReader.close();

            return contracts;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveContractTransaction(ArrayList<Contract> contracts) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/contract.csv"));

            bufferedWriter.newLine();

            for (Contract c : contracts) {
                int vin = c.getVehicleSold().getVin();
                int year = c.getVehicleSold().getYear();
                String make = c.getVehicleSold().getMake();
                String model = c.getVehicleSold().getModel();
                String vehicleType = c.getVehicleSold().getVehicleType();
                String color = c.getVehicleSold().getColor();
                int odometer = c.getVehicleSold().getOdometer();
                double price = c.getVehicleSold().getPrice();

                String userName = c.getCustomerName();
                String userEmail = c.getCustomerEmail();
                String date = c.getDate();
                double totalPrice = c.getTotalPrice();
                double monthlyPayment = c.getMonthlyPayment();
                Vehicle vehicleSold = c.getVehicleSold();

                if (c instanceof SalesContract) {
                    double saleTaxAmount = ((SalesContract) c).getSalesTaxAmount();
                    double recordingFee = ((SalesContract) c).getRecordingFee();
                    double processingFee = ((SalesContract) c).getProcessingFee();
                    double months = ((SalesContract) c).getMonths();
                    boolean hasFinanceOption = ((SalesContract) c).isHasFinanceOption();
                    String salesFormat = String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f", date, userName, userEmail, vin, year, make, model, vehicleType, color, odometer, price, saleTaxAmount, recordingFee, processingFee, totalPrice, hasFinanceOption ? "YES" : "NO", monthlyPayment);
                    bufferedWriter.write(salesFormat);
                    bufferedWriter.newLine();
                }

                else if (c instanceof LeaseContract) {
                    double expectedEndingValue = ((LeaseContract) c).getExpectedEndingValue();
                    double leaseFee = ((LeaseContract) c).getLeaseFee();
                    String leaseFormat = String.format("LEASE|%s|%s|%s|%d|%s|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f", date, userName, userEmail, vin, date, make, model, vehicleType, color, odometer, price, expectedEndingValue, leaseFee, totalPrice, monthlyPayment);
                    bufferedWriter.write(leaseFormat);
                    bufferedWriter.newLine();
                }

            }
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
