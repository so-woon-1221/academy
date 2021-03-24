import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {
    public static void main(String[] args) {
        BufferedReader in = null;
        BufferedWriter out = null;
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket("localhost", 9999);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                System.out.print("보내기 >> ");
                String message = scanner.nextLine();
                System.out.println(message);
                if (message.equals("bye")) {
                    System.out.println(message);
                    out.write(message + "\n");
                    out.flush();
                    break;
                }
                out.write(message + "\n");
                out.flush();
                String inputMessage = in.readLine();
                System.out.println("서버 : " + inputMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                scanner.close();
                if (socket != null) socket.close();
            } catch (Exception e) {
                System.out.println("오류 발생");
            }
        }
    }
}
