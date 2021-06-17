package Task11;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        File file = new File("example.txt");
        InputStream inputStream;
        try {
            inputStream = new FileInputStream(file);
            all:
            while(true){
                String currentRow = "";
                while(true){
                    int currentLetter = inputStream.read();
                    if((char)currentLetter=='\n'){
                        break;
                    }
                    if(currentLetter==-1){
                        System.out.println(currentRow);
                        break all;
                    }
                    currentRow += (char)currentLetter;
                }
                System.out.println(currentRow);
            }
            inputStream.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
