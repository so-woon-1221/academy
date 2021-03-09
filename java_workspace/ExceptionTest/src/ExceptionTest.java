import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("분자 : ");
        int n = scanner.nextInt();

        System.out.print("분모 : ");
        int m = scanner.nextInt();

        try {
            int ans = n/m;
            System.out.println(ans);
        }catch (Exception e) {
            System.out.println(e);
            System.out.println("0으로 나눌 수 없습니다.");
        }
        System.out.println("test");
    }
}
