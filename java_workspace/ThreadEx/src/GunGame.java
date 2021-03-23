import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GunGame extends JFrame {
    int height = 500;
    int width = 500;
    JLabel chicken;
    JLabel bullet;

    public GunGame() {
        this.setTitle("닭 잡기");
        this.setDefaultCloseOperation(3);
        this.setSize(500, 500);

        Container container = this.getContentPane();
        container.setLayout(null);

        JLabel gunBody = new JLabel();
        gunBody.setSize(50, 50);
        gunBody.setLocation(this.getWidth() / 2 - 25, this.getHeight() - 75);
        gunBody.setOpaque(true);
        gunBody.setBackground(Color.black);
        container.add(gunBody);

        chicken = new JLabel();
        chicken.setSize(30, 30);
        chicken.setLocation(0, 0);
        chicken.setOpaque(true);
        chicken.setBackground(Color.red);
        container.add(chicken);


        container.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                BulletThread thread = new BulletThread(container, gunBody, chicken);
                thread.start();
            }
        });

        ChickenThread chickenThread = new ChickenThread(container, chicken);
        chickenThread.start();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GunGame();
    }
}

class BulletThread extends Thread {
    JLabel bullet;
    JLabel gunBody;
    Container container;
    JLabel chicken;

    public BulletThread(Container container, JLabel gunBody, JLabel chicken) {
        this.container = container;
        this.gunBody = gunBody;
        this.chicken = chicken;
        bullet = new JLabel();
    }

    @Override
    public void run() {
        bullet.setSize(10, 10);
        bullet.setLocation(gunBody.getX() + 20, gunBody.getY());
        bullet.setOpaque(true);
        bullet.setBackground(Color.BLUE);
        container.add(bullet);
        while (true) {
            if (bullet.getY() == 0) {
                bullet.setLocation(gunBody.getX() + 20, gunBody.getY());
                break;
            } else {
                bullet.setLocation(bullet.getX(), bullet.getY() - 5);
                try {
                    Thread.sleep(20);
                    if ((bullet.getX() >= chicken.getX() + 30 && bullet.getX() < chicken.getX())
                            && (bullet.getY() >= chicken.getY() + 30) && bullet.getY() < chicken.getY()) {
                        container.removeAll();
                        bullet.setText("Game Over");
                        bullet.setBounds(250, 250, 60, 60);
                        container.add(bullet);
                        System.out.println("ghit");
                        return;
                    }
                    container.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ChickenThread extends Thread {
    JLabel chicken;
    Boolean flag = true;
    Container container;

    public ChickenThread(Container container, JLabel chicken) {
        this.container = container;
        this.chicken = chicken;
    }

    @Override
    public void run() {
        while (flag) {
            if (chicken.getX() == 500) {
                chicken.setLocation(0, 0);
            } else {
                chicken.setLocation(chicken.getX() + 5, chicken.getY());
                try {
                    Thread.sleep(20);
                    container.repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void stopChicken() {
        flag = false;
    }
}
