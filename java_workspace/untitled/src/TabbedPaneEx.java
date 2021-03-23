import javax.swing.*;
import java.awt.*;

public class TabbedPaneEx extends JFrame {
    public TabbedPaneEx() {
        this.setTitle("탭 예제");
        this.setDefaultCloseOperation(3);
        this.setSize(250, 250);

        Container container = this.getContentPane();
        JTabbedPane tabbedPane = createTab();
        container.add(tabbedPane);

        this.setVisible(true);
    }

    private JTabbedPane createTab() {
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add("tab1", new JLabel("superman"));
        tabbedPane.add("tab2", new JLabel("wonder woman"));
        tabbedPane.add("tab3", new Mypanel());

        return tabbedPane;
    }

    class Mypanel extends JPanel {
        public Mypanel() {
            this.setBackground(Color.yellow);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.red);
            g.fillRect(10, 10, 50, 50);
            g.setColor(Color.blue);
            g.fillOval(10, 70, 50, 50);
            g.setColor(Color.black);
            g.drawString("tab 3", 30, 50);
        }
    }

    public static void main(String[] args) {
        new TabbedPaneEx();
    }
}
