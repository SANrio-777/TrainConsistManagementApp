import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        return Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90),
                new Bogie("Second Sitting", 70)
        );
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 70);
        assertTrue(result.stream().allMatch(b -> b.getCapacity() > 70));
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 70);
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() == 70));
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 70);
        assertFalse(result.stream().anyMatch(b -> b.getCapacity() < 70));
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 50);
        assertEquals(4, result.size()); // 72, 70 excluded → actually check carefully
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 100);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(getSampleBogies(), 10);
        assertEquals(getSampleBogies().size(), result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> result = TrainConsistManagementApp.filterBogies(new ArrayList<>(), 70);
        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());
        List<Bogie> copy = new ArrayList<>(original);

        TrainConsistManagementApp.filterBogies(original, 70);

        assertEquals(copy.size(), original.size());
        assertEquals(copy, original);
    }
}