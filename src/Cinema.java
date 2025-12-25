import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        // Print the title
        System.out.println("Cinema: ");

        // Print the first row
        for (int i = 0; i < 9; i++) {
            System.out.print((i == 0) ? "  " : "%d ".formatted(i));
        }

        // Print the rows and columns
        for (int i = 1; i < 8; i++) {
            System.out.printf("%n%d ", i);
            for (int j = 0; j < 8; j++) {
                System.out.print("S ");
            }
        }

        // Read the number of rows and columns
        System.out.println("\nEnter the number of rows:");
        int noOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int noOfColumns = scanner.nextInt();

        // Calculate the number of seats
        int totalSeats = noOfRows * noOfColumns;
        int noOfFrontSeats = (noOfRows / 2) * noOfColumns;
        int noOfBackSeats = totalSeats - noOfFrontSeats;
        int income;

        // Find the total income based on the number of total seats
        if (totalSeats <= 60) {
            income = totalSeats * 10;
        } else {
            income = (noOfFrontSeats * 10) + (noOfBackSeats * 8);
        }

        // Print the income
        System.out.printf("Total income:%n$%d", income);
    }
}