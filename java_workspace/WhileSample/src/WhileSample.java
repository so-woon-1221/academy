import java.util.Scanner;

public class WhileSample {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하고 마지막에 -1을 입력하세요. : ");

        int n = scanner.nextInt();
        while (n != -1) {
            sum += n;
            count++;
            System.out.print("숫자를 입력하세요 : ");
            n = scanner.nextInt();
        }
        if (count == 0) {
            System.out.println("숫자가 입력되지 않았습니다.");
        } else {
            System.out.println("정수의 개수는 " + count + "개 입니다.");
            System.out.println("입력하신 수의 평균은 " + (double) sum / count + "입니다.");
        }
        scanner.close();
    }
}
