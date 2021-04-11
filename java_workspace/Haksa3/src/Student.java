import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Student extends JPanel {
    JTextField tfId;
    JTextField tfName = null;
    JTextField tfDepartment = null;
    JTextField tfAddress = null;

    String[] colName = {"학번", "이름", "학과", "주소"};
    DefaultTableModel model;
    JTable table;

    JButton insertButton;
    JButton selectButton;
    JButton updateButton;
    JButton deleteButton;
    JButton searchButton;

    Connection connection = null;

    public Student(Connection connection) {
        System.out.println("들어옴");
        model = new DefaultTableModel();
        this.connection = connection;

        tfId = new JTextField(18);
        this.add(new JLabel("학번"));
        this.add(tfId);

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
            }
        });
        add(searchButton);

        this.add(new JLabel("이름"));
        tfName = new JTextField(25);
        this.add(tfName);

        this.add(new JLabel("학과"));
        tfDepartment = new JTextField(25);
        this.add(tfDepartment);

        this.add(new JLabel("주소"));
        tfAddress = new JTextField(25);
        this.add(tfAddress);

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
        this.add(new JScrollPane(table));

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
        this.add(insertButton);

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
                    String[] data = {id, name, dept, address};
                    model.addRow(data);
                }
                resultSet.close();
                statement.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        this.add(selectButton);

        updateButton = new JButton("수정");
        updateButton.addActionListener(e -> {
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE STUDENT set name = '" + tfName.getText() + "', dept = '" + tfDepartment.getText()
                        + "', address ='" + tfAddress.getText() + "' where id = '" + tfId.getText() + "'");
                ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                model.setNumRows(0);
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String name = resultSet.getString(2);
                    String dept = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    String[] data = {id, name, dept, address};
                    model.addRow(data);
                }
                resultSet.close();
                statement.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        this.add(updateButton);

        deleteButton = new JButton("삭제");
        this.add(deleteButton);
        deleteButton.addActionListener(e -> {
            int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                try {
                    Statement statement = connection.createStatement();
                    statement.executeUpdate("DELETE FROM STUDENT where id = '" + tfId.getText() + "'");
                    ResultSet resultSet = statement.executeQuery("select * from STUDENT");

                    model.setNumRows(0);
                    while (resultSet.next()) {
                        String id = resultSet.getString(1);
                        String name = resultSet.getString(2);
                        String dept = resultSet.getString(3);
                        String address = resultSet.getString(4);
                        String[] data = {id, name, dept, address};
                        model.addRow(data);
                    }
                    resultSet.close();
                    statement.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
}
