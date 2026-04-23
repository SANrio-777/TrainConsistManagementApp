import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    List<Bogie> sample = Arrays.asList(
            new Bogie("Sleeper", 72),
            new Bogie("AC Chair", 56),
            new Bogie("First Class", 80)
    );

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterWithLoop(sample);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> result = TrainConsistManagementApp.filterWithStream(sample);

        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> loop = TrainConsistManagementApp.filterWithLoop(sample);
        List<Bogie> stream = TrainConsistManagementApp.filterWithStream(sample);

        assertEquals(loop.size(), stream.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long loopTime = TrainConsistManagementApp.measureLoopTime(sample);
        long streamTime = TrainConsistManagementApp.measureStreamTime(sample);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bigList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bigList.add(new Bogie("Sleeper", i));
        }

        List<Bogie> result = TrainConsistManagementApp.filterWithStream(bigList);

        assertTrue(result.stream().allMatch(b -> b.capacity > 60));
    }
}