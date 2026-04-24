import java.util.Arrays;

public class TrainConsistManagementApp {

    public static boolean searchBogie(String[] bogieIds, String key) {

        // Traverse array
        for (String id : bogieIds) {

            // Compare using equals()
            if (id.equals(key)) {
                return true; // Match found → stop early
            }
        }

        return false; // No match found
    }

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("=====================================\n");

        // Sample bogie IDs (unsorted)
        String[] bogieIds = {"BG101","BG205","BG309","BG412","BG550"};
        System.out.println("Available Bogie IDs: \n");
        System.out.println(Arrays.toString(bogieIds));

        String searchKey = "BG309";

        System.out.println("Searching for Bogie ID: " + searchKey);

        boolean found = searchBogie(bogieIds, searchKey);

        if (found) {
            System.out.println("Bogie found in the consist.");
        } else {
            System.out.println("Bogie not found.");
        }

        System.out.println("\nUC18 search completed...");
    }
}