import java.util.Scanner;

class Triangle {
    Scanner scanner = new Scanner(System.in);
    int base;
    int height;

    public void setBase() {
        System.out.print("밑변의 길이를 입력하세요 : ");
        this.base = scanner.nextInt();
    }

    public void setHeight() {
        System.out.print("높이를 입력하세요 : ");
        this.height = scanner.nextInt();
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}
public class No3 {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();

        triangle.setBase();
        triangle.setHeight();
        System.out.println("삼각형의 넓이는 " + triangle.getArea());
    }
}
