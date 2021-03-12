import java.util.Scanner;

interface Mouse2 {
    final Scanner scanner = new Scanner(System.in);
    final int maxX = 500;
    final int maxY = 500;

    public abstract String mouseMove();

    public abstract String click();
}

class WheelMouse2 implements Mouse2 {
    int x;
    int y;

    String leftButton;
    String rightButton;
    String scrollWheel;

    public WheelMouse2() {
    }

    @Override
    public String mouseMove() {
        System.out.println(this.getClass().getName() + "의 세계입니다.");
        System.out.println(this.getClass().getName() + "를 " + "이동할 좌표를 입력하세요");
        System.out.println("end를 입력하면 이동을 마칩니다.");
        System.out.println("x의 최대 이동범위는 " + maxX);
        System.out.println("y의 최대 이동범위는 " + maxY);
        while (true) {
            System.out.print("x 좌표 : ");
            String newX = scanner.nextLine();
            if (newX.equals("end"))
                break;
            else {
                System.out.print("y 좌표 : ");
                String newY = scanner.nextLine();
                if (Integer.parseInt(newX) > maxX || Integer.parseInt(newY) > maxY) {
                    System.out.println(maxX + " 이상 다시 입력하세요");
                } else {
                    x = Integer.parseInt(newX);
                    y = Integer.parseInt(newY);
                }

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

class LaserMouse2 extends WheelMouse2 {
    double moreX;
    double moreY;

    public LaserMouse2() {
        super();
    }

    @Override
    public String mouseMove() {
        String ex = super.mouseMove();
        System.out.println("레이저 마우스는 좀 더 정교하게 움직일 수 있습니다.");
        System.out.print("좀 더 이동할 x 좌표 : ");
        moreX = scanner.nextDouble();
        System.out.print("좀 더 이동할 y 좌표 : ");
        moreY = scanner.nextDouble();
        return this.getClass().getName() + "의 좌표는 " + "(" + (x + moreX) + ", " + (y + moreY) + ")";
    }
}

public class No4 {
    public static void main(String[] args) {
        WheelMouse2 wheelMouse = new WheelMouse2();
        System.out.println(wheelMouse.mouseMove());
        System.out.println(wheelMouse.click());

        LaserMouse2 laserMouse = new LaserMouse2();
        System.out.println(laserMouse.mouseMove());
        System.out.println(laserMouse.click());
    }
}
