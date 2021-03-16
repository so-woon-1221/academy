import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        int c;
        try {
            fileWriter = new FileWriter("/Users/sowoon/Desktop/text.txt");
            while(true) {
                String line = scanner.nextLine();
                if (line.length()==0){
                    break;
                }
                fileWriter.write(line, 0, line.length());
                fileWriter.write("\r\n", 0 ,2);
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("오류");
        }
        scanner.close();
    }
}
