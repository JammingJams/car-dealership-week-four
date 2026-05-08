package com.pluralsight;

import java.io.*;

public class DealershipFileManger {

    public static Dealership getDealership() {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));
            String line = bufferedReader.readLine();
            String[] tempArray = line.split("\\|");

            Dealership dealership = new Dealership(tempArray[0], tempArray[1], tempArray[2]);

            while ((line = bufferedReader.readLine()) != null) {

                tempArray = line.split("\\|");

                try {
                    int vin = Integer.parseInt(tempArray[0]);
                    int year = Integer.parseInt(tempArray[1]);
                    String make = tempArray[2];
                    String model = tempArray[3];
                    String vehicleType = tempArray[4];
                    String color = tempArray[5];
                    int odometer = Integer.parseInt(tempArray[6]);
                    double price = Double.parseDouble(tempArray[7]);

                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                    dealership.getInventory().add(vehicle);
                }

                catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
            bufferedReader.close();

            return dealership;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void saveDealership(Dealership dealership) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"));

            //This turns the Dealership instance into 3 strings that we concatinate
            String name = dealership.getName();
            String address = dealership.getAddress();
            String phone = dealership.getPhone();

            String fullDealershipName = String.format("%s|%s|%s",name,address,phone);

            bufferedWriter.write(fullDealershipName);
            bufferedWriter.newLine();

            for (Vehicle v : dealership.getInventory()) {
                int vin = v.getVin();
                int year = v.getYear();
                String make = v.getMake();
                String model = v.getModel();
                String vehicleType = v.getVehicleType();
                String color = v.getColor();
                int odometer = v.getOdometer();
                double price = v.getPrice();

                String fullVehicleName = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",vin, year, make, model, vehicleType, color, odometer, price);

                bufferedWriter.write(fullVehicleName);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();

        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
