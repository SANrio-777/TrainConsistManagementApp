import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // 1. Valid Train ID
    @Test
    void testRegex_ValidTrainID() {
        assertTrue(TrainConsistManagementApp.isValidTrainId("TRN-1234"));
    }

    // 2. Invalid Train ID format
    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRAIN12"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN12A"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("1234-TRN"));
    }

    // 3. Valid Cargo Code
    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(TrainConsistManagementApp.isValidCargoCode("PET-AB"));
    }

    // 4. Invalid Cargo Code
    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET123"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("AB-PET"));
    }

    // 5. Train ID digit length
    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-123"));
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-12345"));
    }

    // 6. Cargo uppercase validation
    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-Ab"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-aB"));
    }

    // 7. Empty input
    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(TrainConsistManagementApp.isValidTrainId(""));
        assertFalse(TrainConsistManagementApp.isValidCargoCode(""));
    }

    // 8. Exact pattern match
    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(TrainConsistManagementApp.isValidTrainId("TRN-1234XYZ"));
        assertFalse(TrainConsistManagementApp.isValidCargoCode("PET-AB12"));
    }
}