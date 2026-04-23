import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.util.stream.Collectors;
public class TrainConsistManagementAppTest {

    private List<Bogie> getSampleBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));
        return bogies;
    }

    // 1. Bogies grouped by name
    @Test
    public void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> result = getSampleBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
    }

    // 2. Multiple bogies in same group
    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> result = getSampleBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
    }

    // 3. Different bogie categories
    @Test
    public void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> result = getSampleBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(3, result.keySet().size());
    }

    // 4. Empty list handling
    @Test
    public void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();

        Map<String, List<Bogie>> result = emptyList.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.isEmpty());
    }

    // 5. Single category
    @Test
    public void testGrouping_SingleBogieCategory() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> result = list.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(1, result.size());
    }

    // 6. Correct keys
    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> result = getSampleBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    // 7. Group size validation
    @Test
    public void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> result = getSampleBogies().stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(2, result.get("AC Chair").size());
        assertEquals(1, result.get("First Class").size());
    }

    // 8. Original list unchanged
    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<Bogie> original = new ArrayList<>(getSampleBogies());

        original.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        assertEquals(5, original.size());
    }
}