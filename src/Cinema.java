package cinema;

import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);
    static char[][] seatingArrangement;
    static int noOfPurchasedTickets, noOfRows, noOfColumns, income;

    public static void main(String[] args) {
        // Write your code here
        System.out.println("Enter the number of rows:");
        noOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        noOfColumns = scanner.nextInt();
        seatingArrangement = createSeatingArrangement();

        int menuSelection;
        do {
            showMenu();
            menuSelection = scanner.nextInt();
            switch (menuSelection) {
                case 1:
                    printSeatingArrangement();
                    break;
                case 2:
                    seatingArrangement = bookSeat();
                    break;
                case 3:
                    showStatistics();
                    break;
                default:
                    break;
            }

        } while (menuSelection != 0);

    }

    public static char[][] createSeatingArrangement() {
        char[][] seatingArrangement = new char[noOfRows][noOfColumns];

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                seatingArrangement[i][j] = 'S';
            }
        }

        return seatingArrangement;
    }

    public static void showMenu() {
        System.out.println("\n1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void printSeatingArrangement() {
        System.out.println("\nCinema: ");

        for (int i = 0; i <= seatingArrangement[0].length; i++) {
            System.out.print((i == 0) ? "  " : "%d ".formatted(i));
        }

        for (int i = 0; i < seatingArrangement.length; i++) {
            System.out.printf("%n%d ", i + 1);
            for (int j = 0; j < seatingArrangement[i].length; j++) {
                System.out.print(seatingArrangement[i][j] + " ");
            }
        }

        System.out.println();
    }

    public static int calculateTicketPrice(int rowNo) {
        int totalSeats = noOfRows * noOfColumns;
        int price;

        if ((totalSeats > 60) && (rowNo > (noOfRows/2))) {
            price = 8;
        } else {
            price = 10;
        }

        return price;
    }

    public static char[][] bookSeat() {
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("\nEnter a row number: ");
            int rowNo = scanner.nextInt() - 1;
            System.out.println("Enter a seat number in that row:");
            int seatNo = scanner.nextInt() - 1;

            if (rowNo >= noOfRows || seatNo >= noOfColumns || rowNo < 0 || seatNo < 0) {
                System.out.println("\nWrong input!");
            } else if (seatingArrangement[rowNo][seatNo] == 'B') {
                System.out.println("\nThat ticket has already been purchased!");
            } else {
                System.out.printf("%nTicket price: $%d%n", calculateTicketPrice(rowNo + 1));

                seatingArrangement[rowNo][seatNo] = 'B';
                noOfPurchasedTickets++;
                income += calculateTicketPrice(rowNo + 1);
                correctInput = true;
            }
        }

        return seatingArrangement;
    }

    public static double getPercentOfPurchasedTickets() {
        return ((double) noOfPurchasedTickets / (noOfRows * noOfColumns)) * 100;
    }

    public static int getTotalIncome() {
        int totalIncome = 0;

        for (int i = 1; i <= noOfRows; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                totalIncome += calculateTicketPrice(i);
            }
        }

        return totalIncome;
    }

    public static void showStatistics() {
        System.out.println("\nNumber of purchased tickets: " + noOfPurchasedTickets);
        System.out.printf("Percentage: %.2f%%", getPercentOfPurchasedTickets());
        System.out.printf("\nCurrent income: $%d", income);
        System.out.printf("\nTotal income: $%d%n", getTotalIncome());
    }

}