package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    public static Scanner sc = new Scanner(System.in);

    public UserInterface() {
        this.dealership = DealershipFileManger.getDealership();
    }

    public static void display() {

        UserInterface ui = new UserInterface();

        boolean userInMainMenu = true;

        while(userInMainMenu) {
            System.out.print("Welcome to the ");
            System.out.println(ui.getDealership().getName());
            System.out.print("Please select an option\n(1) -> Search vehicle Price\n" +
                    "(2) -> Search vehicle Mileage\n" +
                    "(3) -> Search vehicle Year\n" +
                    "(4) -> Search vehicle Model\n" +
                    "(5) -> Search vehicle Type\n" +
                    "(6) -> Search vehicle color\n" +
                    "(7) -> View all vehicles\n" +
                    "(8) -> Add vehicle\n" +
                    "(9) -> Remove vehicle\n" +
                    "(X) -> Exits program\n");

            String userInput = sc.nextLine().toLowerCase().trim();

            switch (userInput) {
                case ("1") -> ui.processGetByPriceRequest();

                case ("2") -> ui.processGetByMileageRequest();

                case ("3") -> ui.processGetByYearRequest();

                case ("4") -> ui.processGetByMakeModelRequest();

                case ("5") -> ui.processGetByMakeColorRequest();

                case ("6") -> ui.processGetByMakeVehicleTypeRequest();

                case ("7") -> ui.processGetAllVehiclesRequest();

                case ("8") -> ui.processGetAddVehiclesRequest();

                case ("9") -> ui.processGetRemoveVehiclesRequest();

                case ("x") -> userInMainMenu = false;

                default -> System.out.println("Hey type in one of the options");
            }
        }
    }

    public void processGetByPriceRequest() {
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

    }

    public void processGetAddVehiclesRequest() {

    }

    public void processGetRemoveVehiclesRequest() {

    }

    public Dealership getDealership() {
        return dealership;
    }
}
