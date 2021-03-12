import java.util.Scanner;

abstract class Mouse {
    String leftButton;
    String rightButton;
    Scanner scanner;

    int x;
    int y;

    public Mouse() {
    }

    public abstract String mouseMove();

    public abstract String click();
}

class WheelMouse extends Mouse {
    String scrollWheel;

    public WheelMouse() {
        super();
        scanner = new Scanner(System.in);
    }

    @Override
    public String mouseMove() {
        System.out.println(this.getClass().getName() + "의 세계입니다.");
        System.out.println(this.getClass().getName() + "를 " + "이동할 좌표를 입력하세요");
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

        return this.getClass().getName() + "의 좌표는 " + "(" + x + ", " + y + ")";
    }


    @Override
    public String click() {
        System.out.println("클릭 상태를 설정합니다.");
        System.out.print("왼쪽 클릭은 : ");
        leftButton = scanner.nextLine();
        System.out.print("오른쪽 클릭은 : ");
        rightButton = scanner.nextLine();
        String mouse = this.getClass().getName() + "의 왼쪽 버튼은 " + leftButton + ", " + "오른쪽 버튼은 " + rightButton;
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

    @Override
    public String mouseMove() {
        String ex = super.mouseMove();
        System.out.println("레이저 마우스는 좀 더 정교하게 움직일 수 있습니다.");
        System.out.print("좀 더 이동할 x 좌표 : ");
        double moreX = scanner.nextDouble();
        System.out.print("좀 더 이동할 y 좌표 : ");
        double moreY = scanner.nextDouble();
        return this.getClass().getName() + "의 좌표는 " + "(" + (x + moreX) + ", " + (y + moreY) + ")";
    }
}

public class No3 {
    public static void main(String[] args) {
        WheelMouse wheelMouse = new WheelMouse();
        System.out.println(wheelMouse.mouseMove());
        System.out.println(wheelMouse.click());

        LaserMouse laserMouse = new LaserMouse();
        System.out.println(laserMouse.mouseMove());
        System.out.println(laserMouse.click());
    }
}
