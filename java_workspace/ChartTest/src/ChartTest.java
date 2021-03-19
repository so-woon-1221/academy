import javax.swing.*;

public class ChartTest extends JFrame {

    public ChartTest() {
        this.setTitle("분기별 매출");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        this.setSize(500,500);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new ChartTest();
    }
}
