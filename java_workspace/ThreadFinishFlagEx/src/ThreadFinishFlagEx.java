import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class RandomThread extends Thread {
    private Container container;
    private boolean flag = false;

    public RandomThread(Container container) {
        this.container = container;
    }

    public void finish() {
        flag = true;
    }

    @Override
    public void run() {
        while (true) {
            int x = ((int) (Math.random() * container.getWidth()));
            int y = ((int) (Math.random() * container.getHeight()));
            JLabel label = new JLabel("java");
            label.setSize(80, 30);
            label.setLocation(x, y);
            container.add(label);
            container.repaint();
            try {
                Thread.sleep(300);
                if (flag) {
                    container.removeAll();
                    label = new JLabel("finish");
                    label.setSize(80, 30);
                    label.setLocation(100, 100);
                    label.setBackground(Color.red);
                    container.add(label);
                    container.repaint();

                    return;
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}

public class ThreadFinishFlagEx extends JFrame {
    private RandomThread randomThread;

    public ThreadFinishFlagEx() {
        setTitle("ThreadFinishFlag 예제");
        setDefaultCloseOperation(3);
        Container container = getContentPane();
        container.setLayout(null);

        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                randomThread.finish();
            }
        });

        setSize(300, 200);
        setVisible(true);

        randomThread = new RandomThread(container);
        randomThread.start();
    }

    public static void main(String[] args) {
        new ThreadFinishFlagEx();
    }
}
