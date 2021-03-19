import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

public class GraphicsDrawLineMouseEx extends JFrame {
    public MyPanel panel = new MyPanel();

    public GraphicsDrawLineMouseEx() {
        setTitle("drawing Line mouse 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GraphicsDrawLineMouseEx();
    }

    class MyPanel extends JPanel {
        private Vector<Point> vStart = new Vector<>();
        private Vector<Point> vEnd = new Vector<>();

        Point startP = null;
        Point endP = null;

        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    startP = e.getPoint();
                    vStart.add(startP);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    endP = e.getPoint();
                    vEnd.add(endP);

                    repaint();
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    endP = e.getPoint();

                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.blue);

            if(vStart.size() != 0){
                for(int i=0;i<vEnd.size();i++){ //벡터크기만큼
                    Point sp = vStart.get(i); // 벡터값을꺼내다
                    Point ep = vStart.get(i);
                    g.drawLine(sp.x, sp.y, ep.x, ep.y);//그리다
                }
            }
            if(startP != null)
                g.drawLine(startP.x, startP.y, endP.x, endP.y);

//            for (int i = 0; i < vStart.size(); i++) {
//                Point s = vStart.elementAt(i);
//                Point e = vEnd.elementAt(i);
//
//                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
//            }
        }
    }

}
