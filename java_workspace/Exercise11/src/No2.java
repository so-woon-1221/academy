import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No2 extends JFrame {
    String time;
    JLabel hello;

    public No2() {
        time = "인사말이 나옵니다.";
        this.setTitle("시간 나오기");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 10, 10));

        JButton button = new JButton("현재 시간 표시");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
                int hour = Integer.parseInt(dateFormat.format(now.getTime()));

                if (hour < 12) {
                    hello.setText("Good Morning");
                } else if (hour > 12 && hour < 18) {
                    hello.setText("Good Afternoon");
                } else {
                    hello.setText("Good Evening");
                }
            }
        });
        container.add(button);

        hello = new JLabel(time);
        container.add(hello);


        this.setSize(300, 100);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new No2();
    }
}
