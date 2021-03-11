import java.util.Scanner;

class Mouse {
    String leftButton;
    String rightButton;

    int x;
    int y;

    public Mouse() {

    }

    public Mouse(String leftButton, String rightButton) {
        this.leftButton = leftButton;
        this.rightButton = rightButton;
    }

    public String mouseMove(int x, int y) {
        return "(" + x + ", " + y + ")";
    }

    public String click() {
        return "왼쪽 버튼은 " + leftButton + ", " + "오른쪽 버튼은 " + rightButton;
    }
}

class WheelMouse extends Mouse {
    String scrollWheel;

    public WheelMouse(String leftButton, String rightButton, String scrollWheel) {
        super(leftButton, rightButton);
        this.scrollWheel = scrollWheel;
    }

    @Override
    public String click() {
        return super.click() + ", 스크롤은 " + scrollWheel;
    }
}

class LaserMouse extends WheelMouse {
    Scanner scanner = new Scanner(System.in);

    public LaserMouse(String leftButton, String rightButton, String scrollWheel) {
        super(leftButton, rightButton, scrollWheel);
    }

    @Override
    public String mouseMove(int x, int y) {
        System.out.println("레이저 마우스는 좀 더 정교하게 움직일 수 있습니다.");
        System.out.print("좀 더 이동할 x 좌표 : ");
        double moreX = scanner.nextDouble();
        System.out.print("좀 더 이동할 y 좌표 : ");
        double moreY = scanner.nextDouble();
        return "(" + (x + moreX) + ", " + (y + moreY) + ")";
    }
}

public class Exercise7 {
    public static void main(String[] args) {
        Mouse mouse = new Mouse("Clicked", "NotClicked");
        System.out.println("mouse를 이동한 좌표는 " + mouse.mouseMove(200, 40));
        System.out.println(mouse.click());

        WheelMouse wheelMouse = new WheelMouse("Clicked", "NotClicked", "ScrollUp");
        System.out.println("wheelMouse를 이동한 위치는 " + wheelMouse.mouseMove(250, 100));
        System.out.println(wheelMouse.click());

        LaserMouse laserMouse = new LaserMouse("Clicked", "NotClicked", "ScrollUp");
        System.out.println("laserMouse를 이동한 위치는 " + laserMouse.mouseMove(100, 400));
        System.out.println(laserMouse.click());
    }
}
