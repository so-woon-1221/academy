class Person {
    String name;
    String id;

    public Person(String name){
        this.name = name;
    }
}

class Student extends Person {
    String grade;
    String department;

    public Student(String name){
        super(name);
    }
}

public class UpCastingEx {
    public static void main(String[] args) {
        Person p;
        Student s = new Student("aaa");
        p = s; //업캐스팅 -> Student의 모든것을 사용하진 못하고 person 것만 사용 가능

        System.out.println(p.name);

        Person p2 = new Student("aaa2");  //마찬가지로 업캐스팅 -> p2에선 일단 person것만 사용 가능인줄 알았으나 student것도 사용 가능
        Student s2 = (Student) p2; //다운캐스팅 -> 여기선 student 것만 사용가능

        System.out.println(((Student) p2).grade);
        ((Student) p2).grade = "A";
        System.out.println(s2.name);
        System.out.println(s2.grade);
    }
}
