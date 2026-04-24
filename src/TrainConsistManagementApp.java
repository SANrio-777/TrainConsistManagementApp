public class TrainConsistManagementApp {

    // Bubble Sort Method
    public static void bubbleSort(int[] capacities) {

        int n = capacities.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {

            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {

                if (capacities[j] > capacities[j + 1]) {

                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) break;
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
        System.out.println("=========================================\n");

        int[] capacities = {72, 56, 24, 70, 60};

        System.out.println("Original Capacities:");
        displayArray(capacities);

        bubbleSort(capacities);

        System.out.println("\nSorted Capacities (Ascending):");
        displayArray(capacities);

        System.out.println("\nUC16 sorting completed...");
    }
}