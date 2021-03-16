import java.io.FileReader;
import java.io.IOException;

public class FileReaderEx {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("/Users/sowoon/Desktop/티아이에스/자바연습문제07.txt");
            int c;
            while ((c = fileReader.read()) != -1) {
                System.out.print((char) c);
            }
            fileReader.close();
        } catch (IOException e) {
            System.out.println("입출력 오류");
        }
    }
}
