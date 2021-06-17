package Task2;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        printAllTypes(".txt");
    }
    public static void printAllTypes(String type){
        File files = new File("C:/Users/Samo/Desktop");
        File[] innerFiles = files.listFiles();
        for(int i = 0;i<innerFiles.length;i++){
            if(!innerFiles[i].isDirectory()){
                String[] strings = String.valueOf(innerFiles[i].getAbsolutePath()).split("\\.");
                if(type.equals("."+strings[1])){
                    System.out.println(strings[0]+"."+strings[1]);
                }
            }
        }
    }
}
