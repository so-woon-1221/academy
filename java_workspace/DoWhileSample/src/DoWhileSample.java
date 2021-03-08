public class DoWhileSample {
    public static void main(String[] args) {
        char c = 'a';

        do {
            System.out.print(c + " ");
            c = (char) (c + 1);
        } while (c <= 'z');
        System.out.println();

        c = 'a';

        while (c <= 'z') {
            System.out.print(c + " ");
            c += (char) 1;
        }
        System.out.println();

        c = 'a';

        for (; c <= 'z'; c = (char) (c + 1)) {
            System.out.print(c + " ");
        }
    }
}
