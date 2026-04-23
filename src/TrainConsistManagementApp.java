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

        System.out.println("==========================================");
        System.out.println("UC10 - Count Total Seats in Train (reduce) ");
        System.out.println("==========================================");


        // Create list
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Filter using Stream (capacity > 60)
        System.out.println("\nBogies in Train: ");
        int totalSeats = bogies.stream()
                .map(b -> b.getCapacity())  // Extract Capacity
                .reduce(0, Integer::sum);  // Aggregate

        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalSeats);
        System.out.println("\nUC10 aggregation completed...");
    }

    public static int getTotalCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }
}