import java.util.ArrayList;
import java.util.Scanner;

public class No3 {
    public static void main(String[] args) {
        ArrayList<Integer> prob = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();


        Scanner scanner = new Scanner(System.in);
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            int temp = (int) (Math.random() * 9 + 1);
            while (prob.contains(temp)) {
                temp = (int) (Math.random() * 9 + 1);
            }
            prob.add(temp);
        }
        while (true) {
            if (strike == 3) {
                System.out.println("정답입니다.");
                System.out.print("계속 하려면 1 입력, 그만두려면 2 입력 : ");
                int game = Integer.parseInt(scanner.nextLine());
                if (game == 2) {
                    return;
                } else if (game == 1) {
                    prob.clear();
                    ball = 0;
                    strike = 0;
                    for (int i = 0; i < 3; i++) {
                        int temp = (int) (Math.random() * 9 + 1);
                        while (prob.contains(temp)) {
                            temp = (int) (Math.random() * 9 + 1);
                        }
                        prob.add(temp);
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    System.out.print("숫자를 입력하세요 : ");
                    answer.add(Integer.parseInt(scanner.nextLine()));
                }
                ball = 0;
                strike = 0;
                for (int i = 0; i < 3; i++) {
                    if (prob.contains(answer.get(i))) {
                        ball++;
                        if (prob.indexOf(answer.get(i)) == i) {
                            strike++;
                            ball--;
                        }
                    }
                }
                System.out.println("strike : " + strike);
                System.out.println("ball : " + ball);
                answer.clear();
            }
        }
    }
}
