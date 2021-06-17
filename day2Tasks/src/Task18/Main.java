package Task18;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        try{
            InputStream inputStream = new FileInputStream("example.txt");
            String longestWord = "";
            all:
            while(true){
                String currentWord = "";
                while(true){
                    int current = inputStream.read();
                    if(current==-1){
                        if(currentWord.length()>longestWord.length()){
                            longestWord = currentWord;
                        }
                        break all;
                    }
                    if((char)current=='\n'){
                        break ;
                    }
                    if((char)current==' '){
                        break;
                    }
                    currentWord += (char)current;
                }
                if(currentWord.length()>longestWord.length()){
                    longestWord = currentWord;
                }
            }
            inputStream.close();
            System.out.println(longestWord);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
