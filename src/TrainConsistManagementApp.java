import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UC4 - Preserve Insertion Order of Bogies");
        System.out.println("==========================================");

        // Initialize passengerBogies
        Set<String> trainFormation = new LinkedHashSet<>();

        // Add Bogie IDs
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Attempt to add duplicate
        trainFormation.add("Sleeper");

        // Display final formation
        System.out.println("\nFinal Train Formation (Ordered & Unique):");
        System.out.println(trainFormation);

        System.out.println("\nNote:\nLinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("\nUC5 formation setup completed...");

    }
}
