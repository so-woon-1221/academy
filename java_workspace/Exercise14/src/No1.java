import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class No1 extends JFrame {
    JLabel hourLabel;
    JLabel minuteLabel;
    JLabel secondLabel;

    public No1() {
        this.setTitle("디지털 시계");
        this.setDefaultCloseOperation(3);
        this.setSize(200, 100);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 3));

        hourLabel = new JLabel();
        hourLabel.setHorizontalAlignment(SwingConstants.CENTER);
        minuteLabel = new JLabel();
        minuteLabel.setHorizontalAlignment(SwingConstants.CENTER);
        secondLabel = new JLabel();
        secondLabel.setHorizontalAlignment(SwingConstants.CENTER);

        container.add(hourLabel);
        container.add(minuteLabel);
        container.add(secondLabel);

        TimeThread time = new TimeThread(hourLabel, minuteLabel, secondLabel);
        time.start();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new No1();
    }
}

class TimeThread extends Thread {
    JLabel hourLabel;
    JLabel minuteLabel;
    JLabel secondLabel;

    public TimeThread(JLabel hourLabel, JLabel minuteLabel, JLabel secondLabel) {
        this.hourLabel = hourLabel;
        this.minuteLabel = minuteLabel;
        this.secondLabel = secondLabel;
    }

    @Override
    public void run() {
        Calendar now;
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh");
        SimpleDateFormat minuteFormat = new SimpleDateFormat("mm");
        SimpleDateFormat secondFormat = new SimpleDateFormat("ss");

        String hour;
        String minute;
        String second;

        while (true) {
            now = Calendar.getInstance();
            hour = hourFormat.format(now.getTime());
            minute = minuteFormat.format(now.getTime());
            second = secondFormat.format(now.getTime());

            hourLabel.setText(hour);
            minuteLabel.setText(minute);
            secondLabel.setText(second);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}