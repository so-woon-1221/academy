import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopyEx {
    public static void main(String[] args) {
        File src = new File("/Users/sowoon/Desktop/food.jpeg");

        File dest = new File("/Users/sowoon/Desktop/feed.jpeg");
        try {
            FileInputStream inputStream = new FileInputStream(src);
            FileOutputStream outputStream = new FileOutputStream(dest);
            byte[] buf = new byte[1024 * 10];
            while (true) {
                int n = inputStream.read(buf);
                outputStream.write(buf, 0, n);
                if (n < buf.length)
                    break;
            }
            inputStream.close();
            outputStream.close();
            System.out.println(src.getPath() + "를 " + dest.getPath() + "로 복사했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
