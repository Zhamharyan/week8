package CountOfElement;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("example.txt");
        try {
            InputStream inputStream = new FileInputStream(file);
            System.out.println(checkCount(inputStream, 'a'));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int checkCount(InputStream inputStream,char symb){
        int count = 0;
        while (true){
            try {
                int current = inputStream.read();
                if(current==-1){
                    break;
                }
                if((char)current==symb){
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return count;
    }
}
