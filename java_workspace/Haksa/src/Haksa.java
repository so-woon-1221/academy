import javax.swing.*;
import java.awt.*;

public class Haksa extends JFrame {
    JTextField tfId = null;
    JTextField tfName = null;
    JTextField tfDepartment = null;
    JTextField tfAddress = null;

    JTextArea taList = null;

    JButton insertButton = null;
    JButton selectButton = null;
    JButton updateButton = null;
    JButton deleteButton = null;

    public Haksa() {
        this.setTitle("학사관리");
        this.setDefaultCloseOperation(3);

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout());

        tfId = new JTextField(20);
        container.add(new JLabel("학번"));
        container.add(tfId);

        container.add(new JLabel("이름"));
        tfName = new JTextField(20);
        container.add(tfName);

        container.add(new JLabel("학과"));
        tfDepartment = new JTextField(20);
        container.add(tfDepartment);

        container.add(new JLabel("주소"));
        tfAddress = new JTextField(20);
        container.add(tfAddress);

        taList = new JTextArea(10, 23);
        container.add(new JScrollPane(taList));

        insertButton = new JButton("등록");
        container.add(insertButton);

        this.setSize(300, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Haksa();
    }
}
