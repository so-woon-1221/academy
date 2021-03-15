import java.util.Scanner;

public class No7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Boolean check = true;
        String id = "";
        while (check) {
            System.out.print("아이디를 입력하세요 : ");
            id = scanner.nextLine();
            for (int i = 0; i < id.length(); i++) {
                if (id.charAt(i) == '!' || id.charAt(i) == '@' || id.charAt(i) == '#' || id.charAt(i) == '$' || id.charAt(i) == '%' || id.charAt(i) == '^') {
                    check = true;
                    System.out.println("아이디에 !,@,#,$,%,^가 포함되면 안됩니다.");
                    System.out.println("다시 입력하세요");
                    break;
                } else {
                    check = false;
                }
            }
        }
        System.out.println(id + "는 사용할 수 있는 아이디입니다.");
    }
}
