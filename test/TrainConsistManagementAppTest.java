import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PassengerBogieTest {

    // ✅ Valid Capacity
    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
            assertEquals("Sleeper", bogie.type);
            assertEquals(72, bogie.capacity);
        });
    }

    // ❌ Negative Capacity
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("AC", -10);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ❌ Zero Capacity
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ✅ Exception Message Validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(InvalidCapacityException.class, () -> {
            new PassengerBogie("Sleeper", 0);
        });

        assertTrue(exception.getMessage().contains("greater than zero"));
    }

    // ✅ Object Integrity
    @Test
    void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC Sleeper", 64);

        assertEquals("AC Sleeper", bogie.type);
        assertEquals(64, bogie.capacity);
    }

    // ✅ Multiple Valid Bogies
    @Test
    void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC", 60);
            PassengerBogie b3 = new PassengerBogie("Chair", 50);

            assertNotNull(b1);
            assertNotNull(b2);
            assertNotNull(b3);
        });
    }
}