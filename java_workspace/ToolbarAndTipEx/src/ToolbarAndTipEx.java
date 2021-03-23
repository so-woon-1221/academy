import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolbarAndTipEx extends JFrame {
    Container container;

    public ToolbarAndTipEx() {
        this.setTitle("툴바 & 툴팁 예제");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = this.getContentPane();
        createToolBar();
        setSize(400, 150);
        setVisible(true);
    }

    private void createToolBar() {
        JToolBar bar = new JToolBar("Sowoon Menu");
        bar.setBackground(Color.LIGHT_GRAY);

        JButton newButton = new JButton("New");
        newButton.setToolTipText("파일을 생성합니다.");
        bar.add(newButton);

        JButton openButton = new JButton("Open");
        openButton.setToolTipText("파일을 엽니다.");
        bar.add(openButton);
        bar.addSeparator();

        JButton saveButton = new JButton("Save");
        saveButton.setToolTipText("파일을 저장합니다.");
        bar.add(saveButton);

        bar.add(new JLabel("search"));

        JTextField searchField = new JTextField("검색하세요.");
        bar.add(searchField);

        container.add(bar, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new ToolbarAndTipEx();
    }
}
