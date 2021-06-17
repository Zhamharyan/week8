package RandomAccesFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
    public static void main(String[] args) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("example.txt","rw");
            System.out.println(randomAccessFile.readUTF());
            byte[] bytes = new byte[500];
            randomAccessFile.read(bytes);
            System.out.println(bytes);

            randomAccessFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
