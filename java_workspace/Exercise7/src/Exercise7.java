import java.util.Scanner;

class Mouse {
    String leftButton;
    String rightButton;
    Scanner scanner;

    int x;
    int y;

    public Mouse() {

        scanner = new Scanner(System.in);
    }

    public Mouse(String leftButton, String rightButton) {
        scanner = new Scanner(System.in);
        this.leftButton = leftButton;
        this.rightButton = rightButton;
    }

    public String mouseMove() {
        System.out.println(this.toString().split("@")[0]+ "의 세계입니다.");
        int newX = 0;
        int newY = 0;
        System.out.println(this.toString().split("@")[0] + "를 " + "이동할 좌표를 입력하세요");
        System.out.println("end를 입력하면 이동을 마칩니다.");
        while (true) {
            System.out.print("x 좌표 : ");
            String first = scanner.nextLine();
            if (first.equals("end"))
                break;
            else {
                x = Integer.parseInt(first);
                System.out.print("y 좌표 : ");
                y = Integer.parseInt(scanner.nextLine());
            }
        }

        return this.toString().split("@")[0] + "의 좌표는 " + "(" + x + ", " + y + ")";
    }

    public String mouseMove(int x, int y) {
        return this.toString().split("@")[0] + "의 좌표는 " + "(" + x + ", " + y + ")";
    }

    public String click() {
        System.out.println("클릭 상태를 설정합니다.");
        System.out.print("왼쪽 클릭은 : ");
        leftButton = scanner.nextLine();
        System.out.print("오른쪽 클릭은 : ");
        rightButton = scanner.nextLine();
        return this.toString().split("@")[0] + "의 왼쪽 버튼은 " + leftButton + ", " + "오른쪽 버튼은 " + rightButton + "\n";
    }
}

class WheelMouse extends Mouse {
    String scrollWheel;

    public WheelMouse() {
        super();
    }

    public WheelMouse(String leftButton, String rightButton, String scrollWheel) {
        super(leftButton, rightButton);
        this.scrollWheel = scrollWheel;
    }

    @Override
    public String click() {
        String mouse = super.click().split("\n")[0];
        System.out.println("스크롤 상태를 추가로 설정합니다.");
        System.out.print("스크롤 버튼은 : ");
        scrollWheel = scanner.nextLine();
        return mouse + ", 스크롤은 " + scrollWheel + "\n\n";
    }

}

class LaserMouse extends WheelMouse {
    public LaserMouse() {
        super();
    }

    public LaserMouse(String leftButton, String rightButton, String scrollWheel) {
        super(leftButton, rightButton, scrollWheel);
    }

    @Override
    public String mouseMove() {
        String ex = super.mouseMove();
        System.out.println("레이저 마우스는 좀 더 정교하게 움직일 수 있습니다.");
        System.out.print("좀 더 이동할 x 좌표 : ");
        double moreX = scanner.nextDouble();
        System.out.print("좀 더 이동할 y 좌표 : ");
        double moreY = scanner.nextDouble();
        return this.toString().split("@")[0] + "의 좌표는 " + "(" + (x+moreX) + ", " + (y+moreY) + ")";
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Mouse mouse = new Mouse();
        System.out.println(mouse.mouseMove());
        System.out.println(mouse.click());

        WheelMouse wheelMouse = new WheelMouse();
        System.out.println(wheelMouse.mouseMove());
        System.out.println(wheelMouse.click());

        LaserMouse laserMouse = new LaserMouse();
        System.out.println(laserMouse.mouseMove());
        System.out.println(laserMouse.click());
    }
}
