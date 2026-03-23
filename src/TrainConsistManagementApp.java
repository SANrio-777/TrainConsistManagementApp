import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println(" UC2 - Add Passenger Bogies to Train");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        // Initialize passengerBogies
        List<String> passengerBogies = new ArrayList<>();

        // Add Bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display
        System.out.println("\nAfter Adding Bogies:");
        System.out.println(passengerBogies);

        // Remove a Bogie
        passengerBogies.remove("AC Chair");
        System.out.println("\nAfter Removing 'AC Chair':");
        System.out.println(passengerBogies);

        // Check if Sleeper exists
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper? : " + exists);

        System.out.println("\nFinal passenger bogie list:");
        System.out.println(passengerBogies);
        System.out.println("\nUC2 operations completed successfully...");
    }
}
