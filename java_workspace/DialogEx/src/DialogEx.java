import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogEx extends JFrame {
    private MyDialog dialog;

    public DialogEx() {
        super("Dialog 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("show Dialog");

        dialog = new MyDialog(this, "Test Dialog");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);
            }
        });

        getContentPane().add(button);

        setSize(250, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DialogEx();
    }
}

class MyDialog extends JDialog {
    private JTextField textField = new JTextField(10);
    private JButton button = new JButton("OK");

    public MyDialog(JFrame frame, String title) {
        super(frame, title);
        setLayout(new FlowLayout());
        add(textField);
        add(button);

        setSize(200, 100);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
