package Task17;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("C:/Users/Samo/Desktop/example.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            for(int i = 0;i<3;i++){
                System.out.println(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
