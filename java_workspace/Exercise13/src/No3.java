import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class No3 extends JFrame {
    public JTextField appleField;
    public JTextField cherryField;
    public JTextField strawberryField;
    public JTextField pruneField;
    public JPanel textPanel;
    JLabel appleLabel;
    JLabel cherryLabel;
    JLabel strawberryLabel;
    JLabel pruneLabel;
    public int apple;
    public int cherry;
    public int strawberry;
    public int prune;
    int appleR;
    int cherryR;
    int strawberryR;
    int pruneR;

    public No3() {
        setTitle("파이차트");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 600);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(1, 8, 10, 0));
        appleLabel = new JLabel("apple", SwingConstants.RIGHT);
        appleField = new JTextField("", 3);
        appleField.addActionListener(new TextActionListener());
        cherryLabel = new JLabel("cherry", SwingConstants.RIGHT);
        cherryField = new JTextField("", 3);
        cherryField.addActionListener(new TextActionListener());
        strawberryLabel = new JLabel("strawberry", SwingConstants.RIGHT);
        strawberryField = new JTextField("", 3);
        strawberryField.addActionListener(new TextActionListener());
        pruneLabel = new JLabel("prune", SwingConstants.RIGHT);
        pruneField = new JTextField("", 3);
        pruneField.addActionListener(new TextActionListener());

        textPanel.add(appleLabel);
        textPanel.add(appleField);
        textPanel.add(cherryLabel);
        textPanel.add(cherryField);
        textPanel.add(strawberryLabel);
        textPanel.add(strawberryField);
        textPanel.add(pruneLabel);
        textPanel.add(pruneField);

        container.add(textPanel, BorderLayout.NORTH);
        container.add(new GraphPanel(), BorderLayout.CENTER);

        setVisible(true);
    }

    class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            super.setBackground(Color.white);

            //사과
            g.setColor(Color.red);
            g.drawString("apple : " + appleR + "%", appleField.getX(), textPanel.getHeight());
            g.fillArc(super.getWidth() / 2 - 150, super.getHeight() / 2 - 150, 300, 300,
                    0, (int)Math.ceil(appleR * 360.0 / 100));

            //체리
            g.setColor(Color.orange);
            g.drawString("cherry : " + cherryR + "%", cherryField.getX(), textPanel.getHeight());
            g.fillArc(super.getWidth() / 2 - 150, super.getHeight() / 2 - 150, 300, 300,
                    (int)Math.ceil(appleR * 360.0 / 100), (int)Math.ceil(cherryR * 360.0 / 100));

            //딸기
            g.setColor(Color.MAGENTA);
            g.drawString("strawberry : " + strawberryR + "%", strawberryField.getX(), textPanel.getHeight());
            g.fillArc(super.getWidth() / 2 - 150, super.getHeight() / 2 - 150, 300, 300,
                    (int)Math.ceil((appleR * 360.0 / 100)) + (int)Math.ceil((cherryR * 360.0 / 100)),
                    (int)Math.ceil(strawberryR * 360.0 / 100));
//
//            //prune
            g.setColor(Color.blue);
            g.drawString("prune : " + pruneR + "%", pruneField.getX(), textPanel.getHeight());
            g.fillArc(super.getWidth() / 2 - 150, super.getHeight() / 2 - 150, 300, 300,
                    (int)Math.ceil((appleR * 360.0 / 100)) + (int)Math.ceil((cherryR * 360.0 / 100)) + ((int)Math.ceil(strawberryR * 360.0 / 100)),
                    (int)Math.ceil(pruneR * 360.0 / 100));
        }
    }

    class TextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            apple = Integer.parseInt(appleField.getText());
            strawberry = Integer.parseInt(strawberryField.getText());
            cherry = Integer.parseInt(cherryField.getText());
            prune = Integer.parseInt(pruneField.getText());

            if (apple != 0 && cherry != 0 && strawberry != 0 && prune != 0) {
                int sum = apple + cherry + strawberry + prune;
                appleR = (int)Math.ceil(apple * 100.0 / sum);
                cherryR = (int) Math.ceil(cherry * 100.0 / sum);
                strawberryR = (int) Math.ceil(strawberry * 100.0 / sum);
                pruneR = (int) Math.ceil(prune * 100.0 / sum);
            }

            repaint();
        }
    }

    public static void main(String[] args) {
        new No3();
    }
}
