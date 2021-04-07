import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BookRent extends JPanel {
    DefaultTableModel model = null;
    JTable table = null;

    Connection connection;
    Statement statement;

    String query;

    public BookRent() {
        final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String USER = "ora_user"; //아이디
        final String PASS = "hong"; //비밀번호

        query = "select student.id, student.name, books.title, bookRent.rentDate" +
                " from  bookRent, student, books" +
                " where bookRent.studentId=student.id" +
                " and bookRent.bookId=books.bookId";

        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        this.setTitle("책");
//        this.setDefaultCloseOperation(3);

        this.setLayout(null);

        JLabel deptLabel = new JLabel("학과");
        deptLabel.setBounds(10, 10, 30, 20);
        add(deptLabel);

        String[] dept = {"전체", "컴퓨터학부", "연극영화과", "자동차공학과"};
        JComboBox<String> cb_dept = new JComboBox<>(dept);
        cb_dept.setBounds(45, 10, 150, 20);
        cb_dept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                int selectedIndex = cb.getSelectedIndex();

                String newQuery = query;
                if (selectedIndex == 0) {
                    newQuery += " order by student.id";
                } else if (selectedIndex == 1) {
                    newQuery += " and student.dept='Computer'" +
                            " order by books.bookId";
                } else if (selectedIndex == 2) {
                    newQuery += " and student.dept='Acting'" +
                            " order by books.bookId";
                } else if (selectedIndex == 3) {
                    newQuery += " and student.dept='Racing'" +
                            " order by books.bookId";
                }

                list(newQuery);
            }
        });
        add(cb_dept);

        String[] colName = {"학번", "이름", "도서명", "대출일"};
        model = new DefaultTableModel(colName, 0);
        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(470, 200));
        add(table);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10, 40, 460, 250);
        add(sp);

        this.setSize(490, 400);
        this.setVisible(true);

        list(query + " order by student.id");
    }

    public void list(String query) {
        try {
            // Select문 실행
            ResultSet rs = statement.executeQuery(query);

            //JTable 초기화
            model.setNumRows(0);

            while (rs.next()) {
                String[] row = new String[4];//컬럼의 갯수가 4
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                model.addRow(row);
            }
            rs.close();

        } catch (Exception e1) {
            //e.getStackTrace();
            System.out.println(e1.getMessage());
        }
    }

}
