public class No1 {
    public static void main(String[] args) {
        String phone = "010-1234-5678";

        System.out.println("해당 전화번호의 국번을 출력합니다.");
        System.out.println(phone.split("-")[0]);
    }
}
