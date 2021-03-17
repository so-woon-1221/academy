import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No3 extends JFrame {
    JLabel label1;
    JLabel label2;
    JLabel label3;

    public No3() {
        this.setTitle("시간 출력");
        this.setDefaultCloseOperation(3);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 10, 10));

        JButton button1 = new JButton("외부클래스");
        button1.addActionListener(new Button1ActionListener(this));
        container.add(button1);

        label1 = new JLabel("외부클래스");
        container.add(label1);

        JButton button2 = new JButton("내부클래스");
        button2.addActionListener(new Button2ActionListener());
        container.add(button2);

        label2 = new JLabel("내부클래스");
        container.add(label2);

        JButton button3 = new JButton("익명클래스");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일" + "\n" + "HH:mm:ss");
                String time = dateFormat.format(now.getTime());

                label3.setText(time);
            }
        });
        container.add(button3);

        label3 = new JLabel("익명클래스");
        container.add(label3);

        this.setSize(400, 300);
        this.setVisible(true);
    }

    public JLabel getLabel() {
        return label1;
    }

    class Button2ActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Calendar now = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일" + "\n" + "HH:mm:ss");
            String time = dateFormat.format(now.getTime());

            label2.setText(time);
        }
    }

    public static void main(String[] args) {
        new No3();
    }
}

class Button1ActionListener implements ActionListener {
    No3 frame;

    public Button1ActionListener(No3 no3) {
        this.frame = no3;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일" + "\n" + "HH:mm:ss");
        String time = dateFormat.format(now.getTime());

        JLabel label = frame.getLabel();
        label.setText(time);
    }
}
