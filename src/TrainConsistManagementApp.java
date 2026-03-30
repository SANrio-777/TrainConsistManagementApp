import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name+ " - Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println("UC9 - Group Bogies by Type ");
        System.out.println("==================================");


        // Create list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60)); // Duplicate

        // Filter using Stream (capacity > 60)
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        // Show original list (to prove it's unchanged)
        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Group using Stream API
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // Display grouped result
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry: groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }
        System.out.println("\nUC9 filtering completed...");
    }
}