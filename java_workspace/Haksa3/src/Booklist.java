import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Booklist extends JPanel {
    Connection connection;

    String[] book = new String[4];
    ArrayList<String[]> bookList = new ArrayList<>();
    ArrayList<String> rentBookList = new ArrayList<>();

    DefaultTableModel model;
    JTable table;

    public Booklist(Connection connection) {
        this.connection = connection;
        String[] colName = {"도서번호", "제목", "저자", "대여가능"};
        model = new DefaultTableModel(colName, 0);

        try {
            Statement statement1 = connection.createStatement();
            Statement statement2 = connection.createStatement();


            ResultSet bookListQuery = statement1.executeQuery("select * from BOOKS");
            ResultSet rentBook = statement2.executeQuery("select BB.BOOKID\n" +
                    "from BOOKS BB, BOOKRENT BR\n" +
                    "where BR.BOOKID = BB.BOOKID");
            while (bookListQuery.next()) {
                book[0] = bookListQuery.getString(1);
                book[1] = bookListQuery.getString(2);
                book[2] = bookListQuery.getString(3);
                System.out.println(book[1]);
                book[3] = "no";
                bookList.add(book);
                model.addRow(book);
            }
            while (rentBook.next()) {
                rentBookList.add(rentBook.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.setLayout(new BorderLayout());

        JPanel informationPanel = new JPanel(new GridLayout(1, 2));
        JLabel infoLabel = new JLabel("구분");
        String[] info = {"전체", "대여 가능", "대여 불가능"};
        JComboBox infoBox = new JComboBox(info);
        informationPanel.add(infoLabel);
        informationPanel.add(infoBox);
        this.add(informationPanel, BorderLayout.NORTH);

//        for (String[] book : bookList) {
//            String id = book[0];
//            if (rentBookList.contains(id)) {
//                book[3] = "yes";
//                model.addRow(book);
//            }
//        }
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setSize(350, 350);
        this.setVisible(true);
    }
}
