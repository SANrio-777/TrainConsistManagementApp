package TrainConsistManagementApp.src;

class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}


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

            System.out.println(
                    "Cargo assigned successfully -> " + cargoType
            );
        } catch (CargoSafetyException e) {
            System.out.println("Error: Unsafe cargo assignment!");
        } finally {
            System.out.println(
                    "Cargo validation completed for " + shape + " bogie"
            );
            System.out.println();
        }
    }

    private void validateCargo(String cargoType) {

        // Unsafe rule
        if (shape.equals("Rectangular")
                && cargoType.equalsIgnoreCase("Petroleum")) {

            throw new CargoSafetyException("Unsafe cargo");
        }
    }
}
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=====================================");
        System.out.println("UC15 - Safe Cargo Assignment");
        System.out.println("=====================================");
        System.out.println();

        GoodsBogie cylindrical = new GoodsBogie("Cylindrical");
        GoodsBogie rectangular = new GoodsBogie("Rectangular");

        // Safe assignment
        cylindrical.assignCargo("Petroleum");

        // Unsafe assignment
        rectangular.assignCargo("Petroleum");

        System.out.println("UC15 runtime handling completed...");
    }
}