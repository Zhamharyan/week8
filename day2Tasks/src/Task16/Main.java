package Task16;

import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException {
        File file = new File("example.txt");
        try {
            OutputStream outputStream = new FileOutputStream(file,true);
            outputStream.write("apendedtext".getBytes());
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = new FileOutputStream(file,true);
        outputStream.write(78);
        outputStream.close();

    }
}
