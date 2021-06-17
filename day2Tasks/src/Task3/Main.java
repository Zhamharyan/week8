package Task3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Samo/Desktop");
        if(file.exists()){
            System.out.println("This is file");
        }
        else{
            System.out.println("This is not file");
        }
    }
}
