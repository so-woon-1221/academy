import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnoymousClassListener extends JFrame {
    public AnnoymousClassListener() {
        setTitle("익명 클래스 Action 리스너 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        JButton button = new JButton("Action");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();
                if (button.getText().equals("Action")) {
                    button.setText("액션");
                } else {
                    button.setText("Action");
                }
            }
        });
        container.add(button);

        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AnnoymousClassListener();
    }
}
