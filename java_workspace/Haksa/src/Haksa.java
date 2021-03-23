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
    JButton loginButton;

    Boolean isLogin = false;

    public Haksa() {
        this.setTitle("학사관리");
        this.setDefaultCloseOperation(3);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        Container container = new JPanel();
        container.setLayout(new FlowLayout());

        JToolBar toolBar = new JToolBar("로그인");
        loginButton = new JButton("로그인");
        loginButton.addActionListener(new loginActionListener(loginButton, isLogin));
        toolBar.add(loginButton);

        c.add(toolBar, BorderLayout.NORTH);

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
                String name = tfName.getText();
                String number = tfId.getText();
                String department = tfDepartment.getText();
                String address = tfAddress.getText();

                String errorMessage = "";
                if (name.equals("")) {
                    errorMessage += "[이름] ";
                }
                if (number.equals("")) {
                    errorMessage += "[학번] ";
                }
                if (department.equals("")) {
                    errorMessage += "[학과] ";
                }
                if (address.equals("")) {
                    errorMessage += "[주소] ";
                }

                if (errorMessage.equals("")) {
                    JOptionPane.showMessageDialog(null, "등록되었습니다.", "확인", JOptionPane.PLAIN_MESSAGE);
                    taList.append(number + " " + name + " " + department + " " + address);
                    tfName.setText("");
                    tfId.setText("");
                    tfDepartment.setText("");
                    tfAddress.setText("");
                } else {
                    errorMessage += "빈칸입니다.";
                    JOptionPane.showMessageDialog(null, errorMessage, "경고", JOptionPane.ERROR_MESSAGE);
                }
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

        c.add(container, BorderLayout.CENTER);

        this.setSize(350, 500);
        this.setVisible(true);
    }

    class loginActionListener implements ActionListener {
        JButton button;
        Boolean isLogin;

        public loginActionListener(JButton button, Boolean isLogin) {
            this.button = button;
            this.isLogin = isLogin;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!isLogin) {
                JDialog dialog = new JDialog();
                dialog.setTitle("로그인");
                dialog.setSize(200, 200);

                Container container = dialog.getContentPane();
                container.setLayout(new BorderLayout());

                JPanel fieldPanel = new JPanel();
                fieldPanel.setLayout(new GridLayout(2, 2));
                JLabel idLabel = new JLabel("아이디");
                JTextField idField = new JTextField();
                JLabel pwdLabel = new JLabel("비밀번호");
                JPasswordField pwdField = new JPasswordField();
                fieldPanel.add(idLabel);
                fieldPanel.add(idField);
                fieldPanel.add(pwdLabel);
                fieldPanel.add(pwdField);
                container.add(fieldPanel, BorderLayout.CENTER);

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new GridLayout(1, 2));
                JButton loginButton = new JButton("로그인");
                loginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "[ " + idField.getText() + " ]로그인 완료", "로그인",
                                JOptionPane.PLAIN_MESSAGE);
                        dialog.setVisible(false);
                        button.setText("로그아웃");
                        isLogin = true;
                    }
                });
                JButton cancelButton = new JButton("취소");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.setVisible(false);
                    }
                });
                buttonPanel.add(loginButton);
                buttonPanel.add(cancelButton);
                container.add(buttonPanel, BorderLayout.SOUTH);

                dialog.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "로그아웃했습니다.", "로그아웃", JOptionPane.ERROR_MESSAGE);
                button.setText("로그인");
                isLogin = false;
            }
        }
    }

    public static void main(String[] args) {
        new Haksa();
    }
}
