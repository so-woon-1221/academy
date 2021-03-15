import java.util.ArrayList;
import java.util.Scanner;

public class No8 {
    public static void main(String[] args) {
        String name;
        String author;
        String company;
        String price;

        Scanner scanner = new Scanner(System.in);

        ArrayList<String> book = new ArrayList<>();

        System.out.print("책 제목을 입력하세요 : ");
        name = scanner.nextLine();
        book.add(name);
        System.out.print("저자를 입력하세요 : ");
        author = scanner.nextLine();
        book.add(author);
        System.out.print("출판사를 입력하세요 : ");
        company = scanner.nextLine();
        book.add(company);
        System.out.print("가격을 입력하세요 : ");
        price = scanner.nextLine();
        book.add(price);

        System.out.println("책 정보를 출력합니다.");
        for (String s : book) {
            System.out.println(s);
        }
    }
}
