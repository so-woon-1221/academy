import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("국어성적을 입력하세요 : ");
        double korean = scanner.nextDouble();
        System.out.print("영어성적을 입력하세요 : ");
        double english = scanner.nextDouble();
        System.out.print("수학성적을 입력하세요 : ");
        double math = scanner.nextDouble();

        System.out.println("평균은  " + ((korean+english+math)/3.00) + "입니다.");
    }
}
