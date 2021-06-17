package Task10;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("qwe");
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = inputStream.readAllBytes();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
