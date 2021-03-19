import javax.swing.*;
import java.awt.*;

public class ChartTest extends JFrame {
    private MyPanel panel = new MyPanel();

    public ChartTest() {
        this.setTitle("분기별 매출");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(panel); //이 프레임의 컨테이너를 바로 panel로 설

        this.setSize(1000, 1000);
        this.setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            super.setBackground(Color.white);

            //막대그래프
            g.setColor(Color.blue);
            g.fillRect(150, 100, 200, 20); //1분기
            g.fillRect(150, 130, 150, 20); //2분기
            g.fillRect(150, 160, 210, 20);
            g.fillRect(150, 190, 300, 20);

            g.setColor(Color.black);
            g.drawString("1/4분기", 100, 115); //문자열은 왼쪽 하단이 좌표의 기준
            g.drawString("2/4분기", 100, 145);
            g.drawString("3/4분기", 100, 175);
            g.drawString("4/4분기", 100, 205);

            //꺾은선 그래프
            int hGap = 100;
            g.drawLine(100, 600, 100 + hGap, 400);
            g.drawLine(100 + hGap, 400, 100 + hGap * 2, 450);
            g.drawLine(100 + hGap * 2, 450, 100 + hGap * 3, 390);
            g.drawLine(100 + hGap * 3, 390, 100 + hGap * 4, 300);

            //파이차트
            g.setColor(Color.blue);
            g.fillArc(100, 620, 200, 200, 0, 72);

            g.setColor(Color.red);
            g.fillArc(100, 620, 200, 200, 72, 180);

            g.setColor(Color.GREEN);
            g.fillArc(100, 620, 200, 200, 180, 36);

            g.setColor(Color.orange);
            g.fillArc(100, 620, 200, 200, 216, 144);
        }
    }

    public static void main(String[] args) {
        new ChartTest();
    }
}
