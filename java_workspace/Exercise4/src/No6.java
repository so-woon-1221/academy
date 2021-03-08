import java.util.ArrayList;
import java.util.Scanner;

public class No6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("이름을 입력하세요 : ");
            String name = scanner.nextLine();
            if (name.equals("exit"))
                break;
            else {
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        System.out.print("국어 성적을 입력하세요 : ");
                        sum += Integer.parseInt(scanner.nextLine());
                    } else if (i == 1) {
                        System.out.print("영어 성적을 입력하세요 : ");
                        sum += Integer.parseInt(scanner.nextLine());
                    } else {
                        System.out.print("수학 성적을 입력하세요 : ");
                        sum += Integer.parseInt(scanner.nextLine());
                    }
                }
                System.out.println(name + "의 평균성적은 " + (double)sum / 3 + "입니다.");
            }
        }
        System.out.println("종료 되었습니다.");
    }
}
