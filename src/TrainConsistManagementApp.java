package TrainConsistManagementApp.src;

import java.util.ArrayList;
import java.util.List;

class GoodsBogie {
    String type;
    String cargo;
    public GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
    @Override
    public String toString() {
        return "Type: " + type + ", Cargo: " + cargo;
    }
}

public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("===============================================");
        System.out.println("UC12 - Safety Compliance Check for Goods Bogies");
        System.out.println("===============================================");

        // Create list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal"));

        System.out.println("Goods Bogies in Train: ");
        goodsBogies.forEach(System.out::println);
        // Safety compliance check using allMatch
        boolean isSafe = goodsBogies.stream()
                .allMatch(bogie -> {
                    if (bogie.type.equalsIgnoreCase("Cylindrical")) {
                        return bogie.cargo.equalsIgnoreCase("Petroleum");
                    }
                    return true;
                });

        // Display validation result

        System.out.println("\nSafety Compliance Status : " + isSafe);
        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }


        System.out.println("\nUC12 safety validation completed...");

    }
}