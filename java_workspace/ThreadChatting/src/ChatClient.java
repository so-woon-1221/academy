import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends JFrame {
    JTextArea chatArea;
    JTextField chatField;

    BufferedWriter writer;
    BufferedReader reader;
    Socket socket;
    Scanner scanner;

    String nick;

    public ChatClient() {
        this.setTitle("채팅 - 클라이언");
        this.setDefaultCloseOperation(3);
        this.setSize(400, 400);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());

        JToolBar toolBar = new JToolBar();
        JTextField id = new JTextField(10);
        JButton login = new JButton("로그인");
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nick = id.getText();
                chatArea.append(nick + "으로 로그인했습니다." + "\n");
                id.setText("");
            }
        });
        toolBar.add(id);
        toolBar.add(login);

        container.add(toolBar, BorderLayout.NORTH);


        chatArea = new JTextArea();
        container.add(chatArea, BorderLayout.CENTER);

        chatField = new JTextField();
        container.add(chatField, BorderLayout.SOUTH);

        this.setVisible(true);

        try {
            socket = new Socket("localhost", 9999);
            chatArea.append("연결완료" + "\n");
            scanner = new Scanner(System.in);

            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        chatField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = chatField.getText();
                chatArea.append(nick + "(본인) : " + message + "\n");
                chatField.setText("");

                try {
                    writer.write(nick + " : " + message + "\n");
                    writer.flush();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        ReadThread readThread = new ReadThread();
        readThread.start();
    }

    class ReadThread extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    String inputMessage = reader.readLine();
                    chatArea.append(inputMessage + "\n");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}
