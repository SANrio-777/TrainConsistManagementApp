package TrainConsistManagementApp.src;

import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    String type;
    int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return type + " (" + capacity + ")";
    }
}

// Train Consist Management App
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("=====================================");
        // List to store successfully created bogies
        List<PassengerBogie> bogieList = new ArrayList<>();

        // Sample bogie data: {Type, Capacity}
        Object[][] bogieData = {
                {"Sleeper", 72},
                {"AC Chair", 0},      // Invalid
        };


        // Try creating each bogie and handle invalid capacities
        for (Object[] data : bogieData) {
            try {
                PassengerBogie bogie = new PassengerBogie((String) data[0], (int) data[1]);
                bogieList.add(bogie);
                System.out.println("Created bogie: " + bogie);
            } catch (InvalidCapacityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("\nUC14 exception handling completed...");
    }
}