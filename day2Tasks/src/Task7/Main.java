package Task7;

import java.io.File;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Users/Samo/Desktop");
        File[] innerFiles = file.listFiles();
        for(int i = 0;i<innerFiles.length;i++){
            Date d = new Date(innerFiles[i].lastModified());
            System.out.println(innerFiles[i].getAbsolutePath()+"    "+d);
        }
    }
}
