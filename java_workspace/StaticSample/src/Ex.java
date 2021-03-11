class StaticSample {
    public int n ;
    public void g() {
        m= 20;
    }
    public void h() {
        m = 30;
    }

    public static int m;
    public static void f() {
        m = 5;
    }
}
public class Ex {
    public static void main(String[] args) {
        StaticSample.m = 10; //m은 static이라 이렇게 접근 가능

        StaticSample s1;
        s1 = new StaticSample();
        System.out.println(s1.m); //s1으로 접근도 가능하지만 그냥 StaticSample로도 접근가능
        s1.f();
        StaticSample.f();
        System.out.println(StaticSample.m);
    }
}
