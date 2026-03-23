import java.util.LinkedList;
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println(" UC4 - Maintian Ordered Bogie Consist");
        System.out.println("======================================");

        // Initialize passengerBogies
        LinkedList<String> train = new LinkedList<>();

        // Add Bogie IDs
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("\nInitial Train Consist:");
        System.out.println(train);

        // Insert Pantry Car at position 2
        train.add(2, "Pantry");

        System.out.println("\nAfter inserting 'Pantry Car' at position 2:");
        System.out.println(train);

        // Remove first and Last Bogie
        train.removeFirst();
        train.removeLast();
        System.out.println("\nAfter Removing first and Last Bogie:");
        System.out.println(train);

        System.out.println("\nUC4 ordered consist operations completed...");
    }
}
