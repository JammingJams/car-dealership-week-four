package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public static void saveContractTransaction(Dealership dealership, Contract contract) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/resources/contract.csv", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
