import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Exercise12 extends JFrame {
    ImageIcon[] images;
    int count;
    int size;
    JLabel image;
    JButton left;
    JButton right;

    public Exercise12() {
        this.setTitle("갤러리");
        this.setDefaultCloseOperation(3);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        image = new JLabel();
        container.add(image, BorderLayout.CENTER);
        image.setHorizontalAlignment(SwingConstants.CENTER);

        String path = "image";
        File dir = new File(path);
        File[] list = dir.listFiles();
        size = list.length;
        count = 0;
        images = new ImageIcon[size];
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                images[i] = new ImageIcon(list[i].toString());
            }
        }


        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2, 10, 10));
        container.add(buttons, BorderLayout.SOUTH);

        ImageIcon leftICon = new ImageIcon("image/left.png");
        ImageIcon rightIcon = new ImageIcon("image/right.png");

        left = new JButton(leftICon);
        right = new JButton(rightIcon);
        left.addActionListener(new leftButtonEventListener());
        right.addActionListener(new rightButtonEventListener());
        buttons.add(left);
        buttons.add(right);


        this.setSize(400, 400);
        this.setVisible(true);
    }

    class leftButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (count <= 0) {
                count = size - 1;
            }
            System.out.println(images[count]);
            image.setIcon(images[count]);
            count--;
        }
    }

    class rightButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (count >= size) {
                count = 0;
            }
            System.out.println(images[count]);
            image.setIcon(images[count]);
            count++;
        }
    }

    public static void main(String[] args) {
        new Exercise12();
    }
}
