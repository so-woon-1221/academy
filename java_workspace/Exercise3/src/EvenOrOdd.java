import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 : ");
        int num = scanner.nextInt();

        System.out.println("입력하신 수는 " + ((num%2==0)?"짝수입니다.":"홀수입니다"));
    }
}
