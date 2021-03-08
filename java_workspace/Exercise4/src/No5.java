public class No5 {
    public static void main(String[] args) {
        for (int j = 1; j <= 9; j += 2) {
            for (int k = 0; k < (9 - j) / 2; k++) {
                System.out.print(" ");
            }
            for (int k = 0; k < j; k++) {
                System.out.print("*");
            }
            for (int k = 0; k < (9 - j) / 2; k++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
