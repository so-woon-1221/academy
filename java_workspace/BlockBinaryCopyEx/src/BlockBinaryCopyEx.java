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
                int n = inputStream.read(buf);  //파일을 읽어서 buf에 저장한후 저장한 바이트 크기를 n에 리턴
                outputStream.write(buf, 0, n); //buf에 있는 내용을 outputstream에 0부터 n바이트만큼 적음
                if (n < buf.length) //읽은 데이터가 buffer의 최대 사이즈보다 작다면 다 읽은것이기 때문에 끝낸다.
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
