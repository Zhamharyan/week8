import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

public class Main {
    public static void main(String[] args) {

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("example.txt","rw");
            randomAccessFile.writeUTF("K");
            randomAccessFile.seek(randomAccessFile.length()+8);
            randomAccessFile.write("TAZATOX".getBytes());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
