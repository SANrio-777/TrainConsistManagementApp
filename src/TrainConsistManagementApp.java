import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }
    @Override
    public String toString() {
        return name + " (" + capacity + ")";
    }
}

public class TrainConsistManagementApp {
    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithLoop(bogies);
        long end = System.nanoTime();
        return end - start;
    }

    public static long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();
        filterWithStream(bogies);
        long end = System.nanoTime();
        return end - start;
    }
    public static void main(String[] args) {

        System.out.println("================================================");
        System.out.println("UC13 - Performance Comparison (Loops vs Streams)");
        System.out.println("================================================");

        // Create list of goods bogies
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 80),
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 80)
        );


        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        System.out.println("\nLoop execution time (ns): " + loopTime);

        // ----------------- Stream-Based Filtering -----------------
        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        System.out.println("Stream execution time (ns): " + streamTime);


        System.out.println("\nUC13 performance benchmarking completed...");
    }
}