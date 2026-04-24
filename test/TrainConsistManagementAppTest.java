import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // ✅ Bogie Found
    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistManagementApp.searchBogie(ids, "BG309"));
    }

    // ❌ Bogie Not Found
    @Test
    void testSearch_BogieNotFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(TrainConsistManagementApp.searchBogie(ids, "BG999"));
    }

    // ✅ First Element Match
    @Test
    void testSearch_FirstElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistManagementApp.searchBogie(ids, "BG101"));
    }

    // ✅ Last Element Match
    @Test
    void testSearch_LastElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(TrainConsistManagementApp.searchBogie(ids, "BG550"));
    }

    // ✅ Single Element Array
    @Test
    void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};

        assertTrue(TrainConsistManagementApp.searchBogie(ids, "BG101"));
    }
}