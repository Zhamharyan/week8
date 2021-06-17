package Task5;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if(file.isDirectory()){
            System.out.println("This is directory");
        }
        else if(file.isFile()){
            System.out.println("This is file");
        }
    }
}
