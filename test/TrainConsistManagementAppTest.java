import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 60)
        );
    }

    // 1. Total seat calculation
    @Test
    void testReduce_TotalSeatCalculation() {
        int total = TrainConsistManagementApp.getTotalCapacity(getSampleBogies());
        assertEquals(282, total); // 72+56+24+70+60
    }

    // 2. Multiple bogies aggregation
    @Test
    void testReduce_MultipleBogiesAggregation() {
        int total = TrainConsistManagementApp.getTotalCapacity(getSampleBogies());
        assertTrue(total > 0);
    }

    // 3. Single bogie
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> list = Arrays.asList(new Bogie("Sleeper", 72));
        int total = TrainConsistManagementApp.getTotalCapacity(list);
        assertEquals(72, total);
    }

    // 4. Empty list
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> list = new ArrayList<>();
        int total = TrainConsistManagementApp.getTotalCapacity(list);
        assertEquals(0, total);
    }

    // 5. Correct capacity extraction
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> list = getSampleBogies();
        int manualSum = 0;
        for (Bogie b : list) {
            manualSum += b.getCapacity();
        }

        int streamSum = TrainConsistManagementApp.getTotalCapacity(list);
        assertEquals(manualSum, streamSum);
    }

    // 6. All bogies included
    @Test
    void testReduce_AllBogiesIncluded() {
        int total = TrainConsistManagementApp.getTotalCapacity(getSampleBogies());
        assertEquals(282, total);
    }

    // 7. Original list unchanged
    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());

        TrainConsistManagementApp.getTotalCapacity(original);

        assertEquals(5, original.size());
    }
}