import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//독립 클래스
class MyEvent implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 1이 클릭됨");
    }
}

public class EventTest extends JFrame implements ActionListener {
    public EventTest() {
        this.setTitle("이벤트 테스트");
        this.setDefaultCloseOperation(3);

        this.setLayout(new FlowLayout());

        JButton button1 = new JButton("버튼1");
        button1.addActionListener(new MyEvent());
        this.add(button1);

        JButton button2 = new JButton("버튼2");
        button2.addActionListener(new MyEvent2());
        this.add(button2);

        JButton button3 = new JButton("버튼3");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼 3이 클릭됨");
            }
        });
        this.add(button3);

        JButton button4 = new JButton("버튼4");
        button4.addActionListener(this);
        this.add(button4);

        this.setSize(400, 100);
        this.setVisible(true);
    }

    private class MyEvent2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("버튼 2이 클릭됨");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("버튼 4가 클릭됨");
    }

    public static void main(String[] args) {
        new EventTest();
    }
}
