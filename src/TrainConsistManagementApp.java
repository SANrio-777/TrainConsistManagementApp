public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=====================================");
        System.out.println();

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // ✅ Safe assignment
        cylindrical.assignCargo("Petroleum");

        // ❌ Unsafe assignment (handled properly)
        try {
            rectangular.assignCargo("Petroleum");
        } catch (CargoSafetyException e) {
            System.out.println("Handled in main: " + e.getMessage());
        }

        System.out.println("UC15 runtime handling completed...");
    }
}

// ✅ Custom Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// ✅ Goods Bogie Class
class GoodsBogie {

    private String shape;
    private String cargo;

    public GoodsBogie(String shape) {
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {

        try {
            validateCargo(cargoType);
            cargo = cargoType;

            System.out.println("Cargo assigned successfully -> " + cargoType);

        } catch (CargoSafetyException e) {
            System.out.println("Error: Unsafe cargo assignment!");
            throw e;

        } finally {
            System.out.println("Cargo validation completed for " + shape + " bogie");
            System.out.println();
        }
    }

    public String getCargo() {
        return cargo;
    }

    private void validateCargo(String cargoType) {


        if ("Rectangular".equals(shape)
                && "Petroleum".equalsIgnoreCase(cargoType)) {

            throw new CargoSafetyException("Unsafe cargo");
        }
    }
}