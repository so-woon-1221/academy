import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Haksa3 extends JFrame {
    JTextField tfId;
    JTextField tfName = null;
    JTextField tfDepartment = null;
    JTextField tfAddress = null;

    //    JTextArea taList = null;
    String[] colName = {"학번", "이름", "학과", "주소"};
    DefaultTableModel model = null;
    JTable table;

    JButton insertButton;
    JButton selectButton;
    JButton updateButton;
    JButton deleteButton;
    JButton searchButton;

    Boolean isLogin = false;

    Connection connection = null;

    public Haksa3() {
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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

//        JToolBar toolBar = new JToolBar("로그인");
//        loginButton = new JButton("로그인");
//        loginButton.addActionListener(new loginActionListener(loginButton, isLogin));
//        toolBar.add(loginButton);
//
//        c.add(toolBar, BorderLayout.NORTH);

        JMenuBar bar = new JMenuBar();

        JMenu m_student = new JMenu("학생 관리");
        bar.add(m_student);
        JMenu m_book = new JMenu("도서 관리");
        bar.add(m_book);

        JMenuItem mi_list = new JMenuItem("학생 정보");
        m_student.add(mi_list);
        mi_list.addActionListener(e -> {
            this.removeAll();
            this.revalidate();
            this.repaint();
            new Haksa3();
            this.setLayout(new BorderLayout());
            this.setSize(350, 450);
        });

        JMenuItem rent_list = new JMenuItem("대출 목록");
        m_book.add(rent_list);
        rent_list.addActionListener(e -> {
            c.removeAll();
            c.revalidate();
            c.repaint();
            c.add(new BookRent());
            c.setLayout(null);
            this.setSize(490, 400);
        });
        setJMenuBar(bar);

        Container container = new JPanel();
        container.setLayout(new FlowLayout());

        tfId = new JTextField(18);
        container.add(new JLabel("학번"));
        container.add(tfId);

        searchButton = new JButton("검색");
        searchButton.addActionListener(e -> {
            String id = tfId.getText();
            String name = "";
            String dept = "";
            String address = "";
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENT WHERE id = '" + id + "'");
                model.setNumRows(0);
                while (resultSet.next()) {
                    name = resultSet.getString(2);
                    dept = resultSet.getString(3);
                    address = resultSet.getString(4);
                    String[] data = {id, name, dept, address};
                    model.addRow(data);
                }
                tfName.setText(name);
                tfDepartment.setText(dept);
                tfAddress.setText(address);
                resultSet.close();
                statement.close();
            } catch (Exception exception) {
                exception.printStackTrace();
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

        model = new DefaultTableModel(colName, 0);
        table = new JTable(model);
        //taList = new JTextArea(10, 28);
//        taList.setText(DESCRIPTION);
        table.setPreferredScrollableViewportSize(new Dimension(330, 200));
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable clicked = (JTable) e.getSource();
                int row = clicked.getSelectedRow();
                DefaultTableModel nowModel = (DefaultTableModel) clicked.getModel();
                tfId.setText((String) nowModel.getValueAt(row, 0));
                tfName.setText((String) nowModel.getValueAt(row, 1));
                tfDepartment.setText((String) nowModel.getValueAt(row, 2));
                tfAddress.setText((String) nowModel.getValueAt(row, 3));
            }
        });
        container.add(new JScrollPane(table));

        insertButton = new JButton("등록");
        insertButton.addActionListener(e -> {
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

//                        taList.setText(DESCRIPTION);
                    model.setNumRows(0);
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name2 = resultSet.getString(2);
                        String dept = resultSet.getString(3);
                        String address2 = resultSet.getString(4);
                        String[] data = {id, name2, dept, address2};
                        model.addRow(data);
//                            String list = id + "\t" + name2 + "\t" + dept + "\t" + address2 + "\n";

//                            taList.append(list);
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
        });
        container.add(insertButton);

        selectButton = new JButton("목록");
        selectButton.addActionListener(e -> {
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from STUDENT");

//                    taList.setText(DESCRIPTION);
                model.setNumRows(0);
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String dept = resultSet.getString(3);
                    String address = resultSet.getString(4);
//                        String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";
                    String[] data = {id, name, dept, address};
                    model.addRow(data);
//                        taList.append(list);
                }
                resultSet.close();
                statement.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        container.add(selectButton);

        updateButton = new JButton("수정");
        updateButton.addActionListener(e -> {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE STUDENT set name = '" + tfName.getText() + "', dept = '" + tfDepartment.getText()
                        + "', address ='" + tfAddress.getText() + "' where id = '" + tfId.getText() + "'");
                ResultSet resultSet = statement.executeQuery("select * from STUDENT");

//                    taList.setText(DESCRIPTION);
                model.setNumRows(0);
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String dept = resultSet.getString(3);
                    String address = resultSet.getString(4);
//                        String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";
                    String[] data = {id, name, dept, address};
                    model.addRow(data);
//                        taList.append(list);
                }
                resultSet.close();
                statement.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        container.add(updateButton);

        deleteButton = new JButton("삭제");
        container.add(deleteButton);
        deleteButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("DELETE FROM STUDENT where id = '" + tfId.getText() + "'");
                    ResultSet resultSet = statement.executeQuery("select * from STUDENT");

//                        taList.setText(DESCRIPTION);
                    model.setNumRows(0);
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String dept = resultSet.getString(3);
                        String address = resultSet.getString(4);
//                            String list = id + "\t" + name + "\t" + dept + "\t" + address + "\n";
                        String[] data = {id, name, dept, address};
                        model.addRow(data);
//                            taList.append(list);
                    }
                    resultSet.close();
                    statement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        c.add(container, BorderLayout.CENTER);

        this.setSize(350, 450);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Haksa3();
    }
}
