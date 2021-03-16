import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Exercise10 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("계산기 프로그램입니다.");
        System.out.println("숫자 두개를 계산하는 수식을 입력하세요");

        Scanner scanner = new Scanner(System.in);
        String problem = scanner.nextLine();
        String operator = "";
        if (problem.contains("+")) {
            operator = "\\+";
        } else if (problem.contains("-")) {
            operator = "-";
        } else if (problem.contains("*")) {
            operator = "\\*";
        } else if (problem.contains("/")) {
            operator = "/";
        }

        String[] prob = problem.split(operator);
        int answer = 0;
        switch (operator) {
            case "\\+":
                answer = Integer.parseInt(prob[0]) + Integer.parseInt(prob[1]);
                System.out.println("정답은 " + answer);
                break;
            case "-":
                answer = Integer.parseInt(prob[0]) - Integer.parseInt(prob[1]);
                System.out.println("정답은 " + answer);
                break;
            case "\\*":
                answer = Integer.parseInt(prob[0]) * Integer.parseInt(prob[1]);
                System.out.println("정답은 " + answer);
                break;
            case "/":
                try {
                    answer = Integer.parseInt(prob[0]) / Integer.parseInt(prob[1]);
                } catch (Exception e) {
                    String errorMessage = e.getMessage();

                    Calendar now = Calendar.getInstance();
//                    String year = Integer.toString(now.get(Calendar.YEAR));
//                    String month = Integer.toString(now.get(Calendar.MONTH));
//                    String day = Integer.toString(now.get((Calendar.DATE)));
//                    String hour = Integer.toString(now.get(Calendar.HOUR));
//                    String minute = Integer.toString(now.get(Calendar.MINUTE));
//                    String second = Integer.toString(now.get(Calendar.SECOND));
//                    String fileName = year + month + day + hour + minute + second;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                    String fileName = dateFormat.format(now.getTime());

                    FileWriter fileWriter = null;

                    try {
                        fileWriter = new FileWriter("/Users/sowoon/Desktop/" + fileName + ".log");
                        fileWriter.write(now.getTime().toString() + "\n");
                        fileWriter.write(errorMessage, 0, errorMessage.length());
                        fileWriter.write("\r\n");
                        fileWriter.close();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                    System.out.println("0으로 나눌 수 없습니다");
                }
                break;
        }
    }
}
