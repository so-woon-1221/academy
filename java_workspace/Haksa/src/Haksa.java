import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

public class Haksa extends JFrame {
    final String DESCRIPTION = "학번\t이름\t학과\t주소\n" +
            "-----\t-----\t-----\t-----\n";

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
    JButton searchButton;

    Boolean isLogin = false;

    Connection connection = null;

    public Haksa() {
        final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USER = "ora_user"; //아이디
        final String PASS = "hong"; //비밀번호
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

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

        tfId = new JTextField(18);
        container.add(new JLabel("학번"));
        container.add(tfId);

        searchButton = new JButton("검색");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = tfId.getText();
                String name = "";
                String dept = "";
                String address = "";
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT WHERE id = '" + id + "'");
                    while (resultSet.next()) {
                        name = resultSet.getString(2);
                        dept = resultSet.getString(3);
                        address = resultSet.getString(4);
                    }
                    tfName.setText(name);
                    tfDepartment.setText(dept);
                    tfAddress.setText(address);
                    resultSet.close();
                    statement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        container.add(searchButton);

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
        taList.setText(DESCRIPTION);
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
                if (number.equals("")) {
                    errorMessage += "[학번] ";
                }
                if (name.equals("")) {
                    errorMessage += "[이름] ";
                }
                if (department.equals("")) {
                    errorMessage += "[학과] ";
                }
                if (address.equals("")) {
                    errorMessage += "[주소] ";
                }
                if (number.length() != 7 && errorMessage.equals("")) {
                    errorMessage += "학번은 7자리입니다.";
                } else if (number.length() != 7) {
                    errorMessage += "빈칸입니다.\n학번은 7자리입니다.";
                }

                if (errorMessage.equals("")) {
                    try {
                        Statement statement = connection.createStatement();
                        statement.executeUpdate("insert into STUDENT(id,name,dept,address) values ('" + number + "','" + name +
                                "','" + department + "','" + address + "')");
                        ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                        taList.setText(DESCRIPTION);
                        while (resultSet.next()) {
                            String id = resultSet.getString(1);
                            String name2 = resultSet.getString(2);
                            String dept = resultSet.getString(3);
                            String address2 = resultSet.getString(4);
                            String list = id + "\t" + name2 + "\t" + dept + "\t" + address2 + "\n";

                            taList.append(list);
                        }

                        JOptionPane.showMessageDialog(null, "등록되었습니다.", "확인", JOptionPane.PLAIN_MESSAGE);
                        tfName.setText("");
                        tfId.setText("");
                        tfDepartment.setText("");
                        tfAddress.setText("");

                        resultSet.close();
                        statement.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, errorMessage, "경고", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        container.add(insertButton);

        selectButton = new JButton("목록");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                    taList.setText(DESCRIPTION);
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String dept = resultSet.getString(3);
                        String address = resultSet.getString(4);
                        String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";

                        taList.append(list);
                    }
                    resultSet.close();
                    statement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        container.add(selectButton);

        updateButton = new JButton("수정");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("UPDATE STUDENT set name = '" + tfName.getText() + "', dept = '" + tfDepartment.getText()
                            + "', address ='" + tfAddress.getText() + "' where id = '" + tfId.getText() + "'");
                    ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                    taList.setText(DESCRIPTION);
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String dept = resultSet.getString(3);
                        String address = resultSet.getString(4);
                        String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";

                        taList.append(list);
                    }
                    resultSet.close();
                    statement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        container.add(updateButton);

        deleteButton = new JButton("삭제");
        container.add(deleteButton);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        Statement statement = connection.createStatement();
                        statement.executeUpdate("DELETE FROM STUDENT where id = '" + tfId.getText() + "'");
                        ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                        taList.setText(DESCRIPTION);
                        while (resultSet.next()) {
                            String id = resultSet.getString(1);
                            String name = resultSet.getString(2);
                            String dept = resultSet.getString(3);
                            String address = resultSet.getString(4);
                            String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";

                            taList.append(list);
                        }
                        resultSet.close();
                        statement.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        c.add(container, BorderLayout.CENTER);

        this.setSize(350, 400);
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
