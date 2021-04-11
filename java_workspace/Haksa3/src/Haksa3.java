import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Haksa3 extends JFrame {

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

        JMenuBar bar = new JMenuBar();

        JMenu m_student = new JMenu("학생 관리");
        bar.add(m_student);
        JMenu m_book = new JMenu("도서 관리");
        bar.add(m_book);

        JMenuItem mi_list = new JMenuItem("학생 정보");
        m_student.add(mi_list);
        mi_list.addActionListener(e -> {
            System.out.println("학생");
            c.removeAll();
            c.revalidate();
            c.repaint();
            c.add(new Student(connection), BorderLayout.CENTER);
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

        c.add(new Student(connection));

        this.setSize(350, 450);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Haksa3();
    }
}
