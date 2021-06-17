package Task9;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Samo/Desktop/Структуры данных и алгоритмы в Java - Лафоре Р.pdf");
        try {
            InputStream inputStream = new FileInputStream(file);
            byte[] bytes = inputStream.readAllBytes();
            System.out.println("in bytes "+bytes.length);
            int kiloBytes = bytes.length/1024;
            System.out.println("in kiloBytes "+kiloBytes);
            int meegaByte = kiloBytes/1024;
            System.out.println("in megaBytes "+meegaByte);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
