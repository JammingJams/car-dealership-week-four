package com.pluralsight;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    public static Scanner sc = new Scanner(System.in);
    public static UserInterface ui = new UserInterface();

    public UserInterface() {
        this.dealership = DealershipFileManger.getDealership();
    }

    public static void display() {

        boolean userInMainMenu = true;

        while(userInMainMenu) {
            System.out.print("Welcome to the ");
            System.out.println(ui.getDealership().getName());
            System.out.print("Please select an option\n" +
                    "(1) -> View all vehicles\n" +
                    "(2) -> Add vehicle\n" +
                    "(3) -> Remove vehicle\n" +
                    "(X) -> Exits program\n");

            String userInput = sc.nextLine().toLowerCase().trim();

            switch (userInput) {
                case ("1") -> ui.displayVehicles();

                case ("2") -> ui.processGetAddVehiclesRequest();

                case ("3") -> ui.processGetRemoveVehiclesRequest();

                case ("x") -> userInMainMenu = false;

                default -> System.out.println("Hey type in one of the options");
            }
        }
    }

    public void processGetByPriceRequest() {
        boolean userLoop = true;
        double minPrice = 0;
        double maxPrice = 0;
        while (userLoop) {
            System.out.println("Type in the minimum price!");
            try {
                minPrice = sc.nextDouble();
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Don't put strings...");
                sc.nextLine();
            }
        }

        while (userLoop) {
            System.out.println("Type in the minimum price!");
            try {
                maxPrice = sc.nextDouble();
                sc.nextLine();
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Don't put strings...");
                sc.nextLine();
            }
        }

        dealership.getVehiclesByPrice(minPrice,maxPrice);
    }

    public void processGetByMileageRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByMakeColorRequest() {
    }

    public void processGetByMakeVehicleTypeRequest() {
    }

    public void processGetAllVehiclesRequest() {
        for (Vehicle v : dealership.getInventory()) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        }
    }

    public void processGetAddVehiclesRequest() {

    }

    public void processGetRemoveVehiclesRequest() {

    }

    public Dealership getDealership() {
        return dealership;
    }

    public void displayVehicles() {
        boolean userLoop = true;
        while (userLoop) {
            System.out.println("Please select an option\n" +
                    "(1) -> Search vehicle Price\n" +
                    "(2) -> Search vehicle Mileage\n" +
                    "(3) -> Search vehicle Year\n" +
                    "(4) -> Search vehicle Model\n" +
                    "(5) -> Search vehicle Type\n" +
                    "(6) -> Search vehicle color\n" +
                    "(7) -> View all vehicles\n" +
                    "(X) -> Exits to homepage");

            String userInput = sc.nextLine().trim().toLowerCase();

            switch (userInput) {
                case ("1") -> ui.processGetByPriceRequest();

                case ("2") -> ui.processGetByMileageRequest();

                case ("3") -> ui.processGetByYearRequest();

                case ("4") -> ui.processGetByMakeModelRequest();

                case ("5") -> ui.processGetByMakeColorRequest();

                case ("6") -> ui.processGetByMakeVehicleTypeRequest();

                case ("7") -> ui.processGetAllVehiclesRequest();

                case ("X") -> userLoop = false;

                default -> System.out.println("Hey please don't input that...");
            }
        }
    }

    //public void

}
