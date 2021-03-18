import javax.swing.*;
import java.awt.*;

public class ButtonEx extends JFrame {
    public ButtonEx() {
        setTitle("이미지 버튼예제");
        setDefaultCloseOperation(3);
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        ImageIcon normalIcon = new ImageIcon("images/normalIcon.gif");
        ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.gif");
        ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.gif");

        JButton button = new JButton("call~", normalIcon);
        button.setPressedIcon(pressedIcon);
        button.setRolloverIcon(rolloverIcon);
        container.add(button);

        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButtonEx();
    }
}
