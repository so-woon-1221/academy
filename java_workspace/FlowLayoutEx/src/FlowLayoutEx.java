import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
    public FlowLayoutEx() {
        setTitle("FlowLayout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = getContentPane();

        container.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
        container.add(new JButton("aa"));
        container.add(new JButton("bb"));
        container.add(new JButton("cc"));
        container.add(new JButton("dd"));

        setSize(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FlowLayoutEx();
    }
}
