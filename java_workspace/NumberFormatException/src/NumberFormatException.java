public class NumberFormatException {
    public static void main(String[] args) {
        String[] stringNumber = {"23", "12", "3.14", "998"};

        int i = 0;
        try {
            for (i = 0; i < stringNumber.length; i++) {
                int j = Integer.parseInt(stringNumber[i]);
                System.out.println("숫자로 변환된 값은 " + j);
            }
        } catch (java.lang.NumberFormatException e) {
            System.out.println(stringNumber[i] + "는 정수로 변환 불가");
        }
    }
}
