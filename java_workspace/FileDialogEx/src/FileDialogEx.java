import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileDialogEx extends JFrame {
    private final JLabel imageLabel = new JLabel();

    public FileDialogEx() {
        setTitle("파일추저");
        setDefaultCloseOperation(3);
        Container container = this.getContentPane();
        container.add(imageLabel);

        createMenu();

        this.setSize(350, 200);
        this.setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");

        openItem.addActionListener(new OpenActionListener());
        fileMenu.add(openItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    class OpenActionListener implements ActionListener {
        private final JFileChooser chooser;

        public OpenActionListener() {
            chooser = new JFileChooser();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("이미지", "jpg", "png", "gif", "jpeg");
            chooser.setFileFilter(filter);

//            int result = chooser.showOpenDialog(null);
            int result = chooser.showDialog(null, "메롱");
            if (result != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고",
                        JOptionPane.ERROR_MESSAGE);

                return;
            }

            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
            pack();
        }
    }

    public static void main(String[] args) {
        new FileDialogEx();
    }
}
