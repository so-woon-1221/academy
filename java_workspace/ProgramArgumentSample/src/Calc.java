public class Calc {
    public static void main(String[] args) {
        double sum = 0.0;

        for (String arg : args) {
            sum += Double.parseDouble(arg);
        }

        System.out.println("sum = " + sum);
    }
}
