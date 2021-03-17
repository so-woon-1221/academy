import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class No1 extends JFrame {
    int width;
    int height;
    JLabel name;
    JLabel num;
    JLabel major;
    JLabel subject;
    JTextField nameField;
    JTextField numField;
    JTextField majorField;
    JTextField subjectField;

    public No1() {
        width = 300;
        height = 300;
        this.setTitle("학생 정보 입력");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);
        this.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                Component c = (Component) e.getSource();

                width = c.getWidth();
                height = c.getHeight();
                name.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                num.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                major.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                subject.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                nameField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                numField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                majorField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
                subjectField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });

        Container container = this.getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

        name = new JLabel("이름", SwingConstants.CENTER);
        num = new JLabel("학번", 0);
        major = new JLabel("학과", 0);
        subject = new JLabel("과목", 0);

        name.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        num.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        major.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        subject.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));

        nameField = new JTextField("");
        nameField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        numField = new JTextField("");
        numField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        majorField = new JTextField("");
        majorField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));
        subjectField = new JTextField("");
        subjectField.setPreferredSize(new Dimension(width / 2 - 20, height / 4 - 20));

        container.add(name);
        container.add(nameField);
        container.add(num);
        container.add(numField);
        container.add(major);
        container.add(majorField);
        container.add(subject);
        container.add(subjectField);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new No1();
    }

}
