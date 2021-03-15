public class No6 {
    public static void main(String[] args) {
        String datas = "EL201800001,CH201800021,EN12231";
        String[] data = datas.split(",");

        System.out.println("입력한 데이터의 학과를 출력합니다.");
        for (String newData : data) {
            String major = newData.substring(0, 2);
            switch (major) {
                case "EL":
                    System.out.println(major + " : 전자공학과");
                    break;
                case "CH":
                    System.out.println(major + " : 화학공학과");
                    break;
                case "EN":
                    System.out.println(major + " : 영어영문학과");
                    break;
            }
        }
    }
}
