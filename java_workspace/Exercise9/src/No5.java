public class No5 {
    public static void main(String[] args) {
        String datas = "홍길동,010-1111-2222,hkd@hkd.com";

        System.out.println("이름, 번호, 이메일 순으로 출력합니다.");

        String[] data = datas.split(",");
        for (String newData : data) {
            System.out.println(newData);
        }
    }
}
