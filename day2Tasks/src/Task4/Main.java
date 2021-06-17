package Task4;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("W:/Users/Samo/Desktop");
        if(file.exists()) {
            if (file.canWrite()) {
                System.out.println("You can write on file");
            } else {
                System.out.println("You can not write on file");
            }
            if (file.canRead()) {
                System.out.println("You can read file");
            } else {
                System.out.println("You can not read file");
            }
        }
        else{
            System.out.println("No file with such a path");
        }
    }
}
