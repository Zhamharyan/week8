package Task14;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:/Users/Samo/Desktop/example.txt");
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while(true){
                String currentRow = bufferedReader.readLine();
                if(currentRow==null){
                    break;
                }
                lines.add(currentRow);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<lines.size();i++){
            System.out.println(lines.get(i));
        }

    }
}
