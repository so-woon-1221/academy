import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] students = new String[5][2];

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                if (j == 0) {
                    System.out.print("이름을 입력하세요 : ");
                } else {
                    System.out.print("학과를 입력하세요 : ");
                }
                students[i][j] = scanner.nextLine();
            }
        }

        for (int i = 0; i < students.length; i++) {
            for (int j = 0; j < students[i].length; j++) {
                if (j == 0) {
                    System.out.print("이름은 : ");
                } else {
                    System.out.print("학과 : ");
                }
                System.out.println(students[i][j]);
            }
        }
    }
}
