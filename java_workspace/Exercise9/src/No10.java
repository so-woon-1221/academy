import java.util.ArrayList;
import java.util.Scanner;

class Book {
    Scanner scanner;
    String name;
    String author;
    String company;
    String price;

    public Book() {
        scanner = new Scanner(System.in);

        System.out.print("책 제목을 입력하세요 : ");
        name = scanner.nextLine();
        System.out.print("저자를 입력하세요 : ");
        author = scanner.nextLine();
        System.out.print("출판사를 입력하세요 : ");
        company = scanner.nextLine();
        System.out.print("가격을 입력하세요 : ");
        price = scanner.nextLine();
    }

    public void printInfo() {
        System.out.println("책 정보를 출력합니다.");
        System.out.println("책 제목은 " + name);
        System.out.println("저자는 " + author);
        System.out.println("출판사는 " + company);
        System.out.println("가격은 " + price);
        System.out.println();
    }
}

public class No10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> data = new ArrayList<Book>();

        System.out.print("몇개의 책을 넣으실건가요 : ");
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {
            Book temp = new Book();
            data.add(temp);
        }

        for (Book book : data) {
            book.printInfo();
        }
    }
}
