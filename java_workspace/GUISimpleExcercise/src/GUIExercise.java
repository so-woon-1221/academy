import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GUIExercise extends JFrame {
    JLabel keyboard;
    JLabel mouse;
    int maxX;
    int maxY;

    public GUIExercise() {
        this.setTitle("GUI를 연습해봐요");
        this.setDefaultCloseOperation(3);
        this.setSize(300, 300);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2));


        JPanel keyboardPanel = new JPanel();
        keyboardPanel.setLayout(null);
        keyboardPanel.setFocusable(true);
        keyboardPanel.requestFocus();
        keyboardPanel.addKeyListener(new MyKeyListener());
        keyboardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = (Component) e.getSource();
                component.setFocusable(true);
                component.requestFocus();

                Random random = new Random();
                component.setBackground(new Color(random.nextInt(100), random.nextInt(100),
                        random.nextInt(100)));
            }
        });
        keyboardPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component component = (Component) e.getSource();
                maxX = component.getWidth();
                maxY = component.getHeight();

                mouse.setFont(new Font("", Font.PLAIN, getWidth() / 20));
            }
        });
        container.add(keyboardPanel);


        JPanel mousePanel = new JPanel();
        mousePanel.setLayout(null);
        mousePanel.setBackground(Color.PINK);
        mousePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component component = (Component) e.getSource();
                component.setFocusable(true);
                component.requestFocus();

                mouse.setLocation(e.getX(), e.getY());
            }
        });
        mousePanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Component component = (Component) e.getSource();
                component.setFocusable(true);
                component.requestFocus();

                mouse.setLocation(e.getX(), e.getY());
            }
        });
        container.add(mousePanel);

        keyboard = new JLabel("키보드");
        keyboardPanel.add(keyboard);
        keyboard.setBounds(0, 0, 100, 20);

        mouse = new JLabel("마우스");
        mousePanel.add(mouse);
        mouse.setBounds(0, 0, 100, 20);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GUIExercise();
    }

    class MyKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            if (keyboard.getX() > maxX) {
                keyboard.setLocation(0, keyboard.getY());
            } else if (keyboard.getY() > maxY) {
                keyboard.setLocation(keyboard.getX(), 0);
            } else if (keyboard.getX() < 0) {
                keyboard.setLocation(maxX, keyboard.getY());
            } else if (keyboard.getY() < 0) {
                keyboard.setLocation(keyboard.getX(), maxY);
            } else {
                switch (keyCode) {
                    case KeyEvent.VK_UP:
                        keyboard.setLocation(keyboard.getX(), keyboard.getY() - 10);
                        break;
                    case KeyEvent.VK_DOWN:
                        keyboard.setLocation(keyboard.getX(), keyboard.getY() + 10);
                        System.out.println(keyboard.getY());
                        break;
                    case KeyEvent.VK_LEFT:
                        keyboard.setLocation(keyboard.getX() - 10, keyboard.getY());
                        break;
                    case KeyEvent.VK_RIGHT:
                        keyboard.setLocation(keyboard.getX() + 10, keyboard.getY());
                        break;
                }
            }
        }
    }
}
