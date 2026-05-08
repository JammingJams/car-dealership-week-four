package com.pluralsight;

import java.util.InputMismatchException;
import java.util.List;
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
        double[] prices = ui.userInterfaceAskUserInput();
        double min = prices[0];
        double max = prices[1];

        dealership.getVehiclesByPrice(min, max);
    }

    public void processGetByMileageRequest() {
        double[] miles = ui.userInterfaceAskUserInput();
        double min = miles[0];
        double max = miles[1];

        dealership.getVehiclesByPrice(min, max);
    }

    public void processGetByYearRequest() {
        double[] years = ui.userInterfaceAskUserInput();
        double min = years[0];
        double max = years[1];

        dealership.getVehiclesByPrice(min, max);
    }

    public void processGetByMakeModelRequest() {
        String[] makeModel = ui.userInterfaceAskUserInputStrings();
        String make = makeModel[0];
        String model = makeModel[1];

        dealership.getVehiclesByMakeModel(make, model);
    }

    public void processGetByMakeColorRequest() {
        String color = ui.userInterfaceAskUserInputString("color");

        dealership.getVehiclesByColor(color);
    }

    public void processGetByMakeVehicleTypeRequest() {
        String vehicleType = ui.userInterfaceAskUserInputString("vehicle type");

        List<Vehicle> test = dealership.getVehiclesByColor(vehicleType);
    }

    public void processGetAllVehiclesRequest() {
        for (Vehicle v : dealership.getInventory()) {
            System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n",v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
        }
    }

    public void processGetAddVehiclesRequest() {
        ui.checkUserSearch("a");

    }

    public void processGetRemoveVehiclesRequest() {
        ui.checkUserSearch("r");

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

                case ("x") -> userLoop = false;

                default -> System.out.println("Hey please don't input that...");
            }
        }
    }

    public double[] userInterfaceAskUserInput() {
        boolean userLoop = true;
        double minPrice = 0;
        double maxPrice = 0;

        while (userLoop) {
            System.out.println("Type in the minimum price!");
            try {
                minPrice = sc.nextDouble();
                sc.nextLine();
                userLoop = false;
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Don't put strings...");
                sc.nextLine();
            }
        }

        userLoop = true;

        while (userLoop) {
            System.out.println("Type in the maximum price!");
            try {
                maxPrice = sc.nextDouble();
                sc.nextLine();
                userLoop = false;
            }
            catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.print("Don't put strings...");
                sc.nextLine();
            }
        }
        double[] minMaxPrice = {minPrice, maxPrice};

        return minMaxPrice;
    }

    public String userInterfaceAskUserInputString(String checkType) {
        System.out.printf("Hey what is the %s you want: ", checkType);
        String condition = sc.nextLine().trim().toLowerCase();

        return condition;
    }

    public String[] userInterfaceAskUserInputStrings() {
        System.out.print("Hey what is the Make you want: ");
        String conditionOne = sc.nextLine().trim().toLowerCase();

        System.out.print("Hey what is the Model you want: ");
        String conditionTwo = sc.nextLine().trim().toLowerCase();

        String[] conditions = {conditionOne, conditionTwo};

        return conditions;
    }

    public void checkUserSearch(String option) {
        String check = "";
        if (option.equalsIgnoreCase("a")) {
            check = "adding";
        }

        else if (option.equalsIgnoreCase("r")) {
            check = "removing";
        }

        System.out.printf("Type in a vehicle you would be interested in %s: ", check);
        String userChoice = sc.nextLine().trim();
        boolean noMatchFound = true;

        for (Vehicle v : dealership.getInventory()) {
            if (userChoice.equalsIgnoreCase(v.getColor()) || userChoice.equalsIgnoreCase(v.getVehicleType())
                    || userChoice.equalsIgnoreCase(v.getMake()) || userChoice.equalsIgnoreCase(v.getModel())
                    || userChoice.equalsIgnoreCase(String.valueOf(v.getPrice())) || userChoice.equalsIgnoreCase(String.valueOf(v.getYear()))
                    || userChoice.equalsIgnoreCase(String.valueOf(v.getOdometer())) || userChoice.equalsIgnoreCase(String.valueOf(v.getVin())))
            {
                if (option.equalsIgnoreCase("a")) {
                    printOutVehicle(v);
                    ui.dealership.addVehicle(v);
                    noMatchFound = false;
                }
                else if (option.equalsIgnoreCase("r")) {
                    printOutVehicle(v);
                    ui.dealership.removeVehicle(v);
                    noMatchFound = false;
                }

            }

            if (noMatchFound) {
                System.out.println("No match found :(");
            }

        }

    }

    public static void printOutVehicle(Vehicle v) {
        System.out.printf("%d|%d|%s|%s|%s|%s|%d|%.2f\n", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
    }

}
