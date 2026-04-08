package TrainConsistManagementApp.src;

public class TrainConsistManagementApp {

    // Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;

        // Number of passes
        for (int i = 0; i < n - 1; i++) {

            // Compare adjacent elements
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if elements are out of order
                if (capacities[j] > capacities[j + 1]) {

                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // Display array values
    public static void displayArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {

        System.out.println("=========================================");
        System.out.println("UC16 - Manual Sorting using Bubble Sort");
        System.out.println("=========================================");
        System.out.println();

        // Passenger bogie capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Original Capacities: \n");
        displayArray(capacities);

        // Perform Bubble Sort
        bubbleSort(capacities);

        System.out.print("\nSorted Capacities (Ascending):   \n");
        displayArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }
}