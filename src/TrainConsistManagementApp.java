import java.util.Scanner;

public class TrainConsistManagementApp {

    // ✅ Validation methods INSIDE class
    public static boolean isValidTrainId(String trainId) {
        return trainId != null && trainId.matches("^TRN-\\d{4}$");
    }

    public static boolean isValidCargoCode(String cargoCode) {
        return cargoCode != null && cargoCode.matches("^PET-[A-Z]{2}$");
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("==========================================");

        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainID = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ✅ Use your methods
        boolean isTrainValid = isValidTrainId(trainID);
        boolean isCargoValid = isValidCargoCode(cargoCode);

        // Output
        System.out.println("\nValidation Results:");
        System.out.println("Train ID valid: " + isTrainValid);
        System.out.println("Cargo Code valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}