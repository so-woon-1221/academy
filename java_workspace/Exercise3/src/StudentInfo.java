import java.util.Scanner;

public class StudentInfo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        String name = scanner.nextLine();
        System.out.print("학번을 입력하세요 : ");
        String studentNum = scanner.nextLine();
        System.out.print("학과를 입력하세요 : ");
        String major = scanner.nextLine();

        System.out.println("이름은 " + name + ", 학번은 " + studentNum + ", 학과는 " + major + "입니다.");
    }
}
