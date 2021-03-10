import java.util.Scanner;

class Student {
    String name;
    String major;

    public Student() {
        this("", "");
    }

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void printInfo() {
        System.out.println(this.name + "의 학과는 " + this.major);
    }
}

public class No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Student student = new Student();

        System.out.print("이름을 입력하세요 : ");
        student.setName(scanner.nextLine());
        System.out.print("학과를 입력하세요 : ");
        student.setMajor(scanner.nextLine());

        student.printInfo();
    }
}
