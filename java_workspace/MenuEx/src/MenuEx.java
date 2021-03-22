import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuEx extends JFrame {
    public MenuEx() {
        this.setTitle("메뉴 연습");
        createMenu();
        this.setSize(250, 200);
        this.setVisible(true);
    }

    public void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu screenMenu = new JMenu("Scree");

        MenuActionListener listener = new MenuActionListener();
        JMenuItem loadMenu = new JMenuItem("Load");
        loadMenu.addActionListener(listener);
        JMenuItem hideMenu = new JMenuItem("Hide");
        hideMenu.addActionListener(listener);
        JMenuItem reShowMenu = new JMenuItem("Reshow");
        reShowMenu.addActionListener(listener);
        JMenuItem exitMenu = new JMenuItem("Exit");
        exitMenu.addActionListener(listener);

        screenMenu.add(loadMenu);
        screenMenu.add(hideMenu);
        screenMenu.add(reShowMenu);
        screenMenu.addSeparator();
        screenMenu.add(exitMenu);

        menuBar.add(screenMenu);
        menuBar.add(new JMenu("Edit"));
        menuBar.add(new JMenu("Source"));
        menuBar.add(new JMenu("Project"));
        menuBar.add(new JMenu("Run"));

        setJMenuBar(menuBar);
    }

    class MenuActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String item = e.getActionCommand();

            switch (item) {
                case "Load":
                    System.out.println("load");
                    break;
                case "Hide":
                    System.out.println("hide");
                    break;
                case "Reshow":
                    System.out.println("reshow");
                    break;
                case "Exit":
                    System.out.println("Exit");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new MenuEx();
    }
}
