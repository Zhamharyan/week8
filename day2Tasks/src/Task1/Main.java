package Task1;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Samo/Desktop");
        File[] fileList = file.listFiles();
        for(int i = 0;i<fileList.length;i++){
            System.out.println(fileList[i].getName());
        }
    }
}
