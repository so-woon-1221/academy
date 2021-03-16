import java.io.BufferedOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BufferedIOEx {
    public static void main(String[] args) {
        FileReader reader = null;
        int c;
        try {
            reader = new FileReader("/Users/sowoon/Desktop/text.txt");
            BufferedOutputStream outputStream = new BufferedOutputStream(System.out, 5);
            while ((c = reader.read()) != -1) {
                outputStream.write(c); //5바이트가 꽉차면 출력됨
            }
            new Scanner(System.in).nextLine();
            outputStream.flush(); //나머지 읽은거 강제 출력
            reader.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
