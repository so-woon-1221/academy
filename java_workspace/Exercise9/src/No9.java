import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class No9 {
    public static void main(String[] args) {
        HashMap<String, String> book = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String name;
        String author;
        String company;
        String price;

        System.out.print("책 제목을 입력하세요 : ");
        name = scanner.nextLine();
        book.put("책 제목", name);
        System.out.print("저자를 입력하세요 : ");
        author = scanner.nextLine();
        book.put("저자", author);
        System.out.print("출판사를 입력하세요 : ");
        company = scanner.nextLine();
        book.put("출판사", company);
        System.out.print("가격을 입력하세요 : ");
        price = scanner.nextLine();
        book.put("가격", price);

        Set<String> set = book.keySet();
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            String info = iterator.next();
            System.out.println(info + "는 " + book.get(info));
        }
    }
}
