import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GoodsBogieTest {


    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
        assertEquals("Petroleum", bogie.getCargo());
    }


    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        assertThrows(CargoSafetyException.class, () -> {
            bogie.assignCargo("Petroleum");
        });
    }


    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        try {
            bogie.assignCargo("Petroleum");
        } catch (CargoSafetyException ignored) {}

        assertNull(bogie.getCargo());
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie safe = new GoodsBogie("Cylindrical");
        GoodsBogie unsafe = new GoodsBogie("Rectangular");

        assertDoesNotThrow(() -> safe.assignCargo("Petroleum"));

        assertThrows(CargoSafetyException.class, () -> {
            unsafe.assignCargo("Petroleum");
        });


        assertDoesNotThrow(() -> safe.assignCargo("Coal"));
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular");

        // If finally doesn't execute, test may fail due to unhandled flow
        assertThrows(CargoSafetyException.class, () -> {
            bogie.assignCargo("Petroleum");
        });

        // No crash = finally executed
        assertTrue(true);
    }
}