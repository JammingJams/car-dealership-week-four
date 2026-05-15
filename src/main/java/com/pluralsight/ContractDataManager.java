package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractDataManager {

    public static ArrayList<Contract> getContractTransaction() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/contract.csv"));
            String line = bufferedReader.readLine();
            String[] tempArray = line.split("\\|");

            ArrayList<Contract> contracts = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {

                tempArray = line.split("\\|");

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

    public static void saveContractTransaction() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/contract.csv"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
