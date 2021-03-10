import java.util.Scanner;

class Students {
    String name;
    String major;
    Scanner scanner = new Scanner(System.in);

    public Students() {
        this("", "");
    }

    public Students(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public void setName() {
        System.out.print("이름을 입력하세요 : ");
        this.name = scanner.nextLine();
    }

    public void setMajor() {
        System.out.print("학과를 입력하세요 : ");
        this.major = scanner.nextLine();
    }

    public void printInfo() {
        System.out.println(this.name + "의 학과는 " + this.major);
    }
}

public class No2 {
    public static void main(String[] args) {
        Students[] students = new Students[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Students();
            students[i].setName();
            students[i].setMajor();
        }

        for (Students student : students) {
            student.printInfo();
        }
    }
}
