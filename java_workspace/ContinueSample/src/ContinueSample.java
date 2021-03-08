import java.util.Scanner;

public class ContinueSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i< 5; i++){
            int n = scanner.nextInt();
            if (n<=0)
                continue;
            sum+=n;
        }

        System.out.println("양수의 합은 " + sum);

        scanner.close();
    }
}
