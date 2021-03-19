import javax.swing.*;
import java.awt.*;

public class No1 extends JFrame {
    MyPanel panel = new MyPanel();

    public No1() {
        setTitle("꺾은선 그래프");
        setDefaultCloseOperation(3);
        setContentPane(panel);
        setSize(700, 500);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            super.setBackground(Color.white);

            //꺾은선 그래프
            g.setColor(Color.black);
            int hGap = 100;
            g.drawLine(100, 400, 100 + hGap, 200);
            g.drawLine(100 + hGap, 200, 100 + hGap * 2, 250);
            g.drawLine(100 + hGap * 2, 250, 100 + hGap * 3, 190);
            g.drawLine(100 + hGap * 3, 190, 100 + hGap * 4, 100);

            //x,y축
            g.setColor(Color.red);
            g.drawLine(100, 400, 100 + hGap * 5, 400);
            g.drawLine(100, 400, 100, 90);

            //분기 표시
            g.setColor(Color.gray);
            g.drawLine(100 + hGap, 400, 100 + hGap, 200);
            g.drawString("1/4분기", 100 + hGap - 20, 420);
            g.drawLine(100 + hGap * 2, 400, 100 + hGap * 2, 250);
            g.drawString("2/4분기", 100 + hGap * 2 - 20, 420);
            g.drawLine(100 + hGap * 3, 400, 100 + hGap * 3, 190);
            g.drawString("3/4분기", 100 + hGap * 3 - 20, 420);
            g.drawLine(100 + hGap * 4, 400, 100 + hGap * 4, 100);
            g.drawString("4/4분기", 100 + hGap * 4 - 20, 420);

            //매출액표시
            //지저분해서 선 삭제
//            g.drawLine(100, 200, 100 + hGap, 200);
//            g.drawLine(100, 250, 100 + hGap * 2, 250);
//            g.drawLine(100, 190, 100 + hGap * 3, 190);
            g.drawLine(100, 100, 100 + hGap * 4, 100);
            g.drawString("100억", 50, 305);
            g.drawString("200억", 50, 205);
            g.drawString("300억", 50, 105);
        }
    }

    public static void main(String[] args) {
        new No1();
    }
}
