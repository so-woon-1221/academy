import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class No2 extends JFrame {
    JLabel colorLabel;

    public No2() {
        this.setTitle("색 바꾸기");
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 1));

        JMenuBar bar = new JMenuBar();
        JMenu colorMenu = new JMenu("COLOR");
        JMenuItem red = new JMenuItem("RED");
        JMenuItem green = new JMenuItem("GREEN");
        JMenuItem blue = new JMenuItem("BLUE");
        colorMenu.add(red);
        colorMenu.add(green);
        colorMenu.add(blue);
        bar.add(colorMenu);

        colorLabel = new JLabel();
        colorLabel.setOpaque(true);
        container.add(colorLabel);

        MenuListener listener = new MenuListener();
        red.addActionListener(listener);
        green.addActionListener(listener);
        blue.addActionListener(listener);

        setJMenuBar(bar);
        this.setVisible(true);
    }

    class MenuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String color = e.getActionCommand();

            switch (color) {
                case "RED":
                    colorLabel.setBackground(Color.RED);
                    break;
                case "GREEN":
                    colorLabel.setBackground(Color.GREEN);
                    break;
                case "BLUE":
                    colorLabel.setBackground(Color.BLUE);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new No2();
    }
}
