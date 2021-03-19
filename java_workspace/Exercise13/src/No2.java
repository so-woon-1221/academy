import javax.swing.*;
import java.awt.*;

public class No2 extends JFrame {
    MyPanel2 panel = new MyPanel2();

    public No2() {
        setTitle("파이차");
        setDefaultCloseOperation(3);
        setContentPane(panel);
        setSize(700, 500);
        setVisible(true);
    }

    class MyPanel2 extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            super.setBackground(Color.GRAY);

            //그래프
            g.setColor(Color.blue);
            g.fillArc(100, 120, 200, 200, 0, 90);
            g.setColor(Color.red);
            g.fillArc(100, 120, 200, 200, 90, 80);
            g.setColor(Color.GREEN);
            g.fillArc(100, 120, 200, 200, 170, 70);
            g.setColor(Color.orange);
            g.fillArc(100, 120, 200, 200, 240, 120);

            //범례
            g.setColor(Color.white);
            g.fillRect(330, 160, 150, 90);
            g.setColor(Color.blue);
            g.drawString("1/4분기 90억", 350, 180);
            g.setColor(Color.red);
            g.drawString("2/4분기 80억", 350, 200);
            g.setColor(Color.GREEN);
            g.drawString("3/4분기 70억", 350, 220);
            g.setColor(Color.orange);
            g.drawString("4/4분기 120억", 350, 240);
        }
    }

    public static void main(String[] args) {
        new No2();
    }
}
