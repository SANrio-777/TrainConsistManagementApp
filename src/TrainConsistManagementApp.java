import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("====================================");
        System.out.println("   UC3 - Track Unique Bogie IDs");
        System.out.println("====================================");

        // Initialize passengerBogies
        Set<String> bogieIds = new HashSet<>();

        // Add Bogie IDs
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display
        System.out.println("Bogie IDs After Insertion: ");
        System.out.println(bogieIds);


        System.out.println("\nNote:\nDuplicates are automatically ignored by HashSet.");
        System.out.println("\nUC3 uniqueness validation completed...");

    }
}
