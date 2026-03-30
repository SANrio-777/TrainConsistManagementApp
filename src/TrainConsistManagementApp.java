package TrainConsistManagementApp.src;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");

        Scanner scanner = new Scanner(System.in);

        // Read user input
        System.out.println("Enter Train ID (Format: TRN-1234): ");
        String trainID = scanner.nextLine();

        System.out.println("Enter Cargo Code (Format: PET-AB");
        String cargoCode = scanner.nextLine();

        // Define regex patterns
        String trainIDPattern = "TRN-\\d{4}";
        String cargoCodePattern = "PET-[A-Z]{2}";

        // Validate
        boolean isTrainPattern = Pattern.matches(trainIDPattern, trainID);
        boolean isCargoCodeValid = Pattern.matches(cargoCodePattern, cargoCode);

        // Display validation result
        System.out.println("Validation Results:");
        System.out.println("Train ID valid: " + isTrainPattern);
        System.out.println("Cargo code valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}