import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        tfId = new JTextField(25);
        container.add(new JLabel("학번"));
        container.add(tfId);

        container.add(new JLabel("이름"));
        tfName = new JTextField(25);
        container.add(tfName);

        container.add(new JLabel("학과"));
        tfDepartment = new JTextField(25);
        container.add(tfDepartment);

        container.add(new JLabel("주소"));
        tfAddress = new JTextField(25);
        container.add(tfAddress);

        taList = new JTextArea(10, 28);
        container.add(new JScrollPane(taList));

        insertButton = new JButton("등록");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "등록되었습니다.");
            }
        });
        container.add(insertButton);

        selectButton = new JButton("목록");
        container.add(selectButton);

        updateButton = new JButton("수정");
        container.add(updateButton);

        deleteButton = new JButton("삭제");
        container.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    //삭제처리
                }
            }
        });

        this.setSize(350, 500);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Haksa();
    }
}
