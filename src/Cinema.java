public class Cinema {

    public static void main(String[] args) {
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
    }
}