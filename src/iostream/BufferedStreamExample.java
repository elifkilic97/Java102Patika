package iostream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BufferedStreamExample {
    public static void main(String[] args){
        try {
            FileInputStream fileInput = new FileInputStream("patika.txt");
            BufferedInputStream buffInput = new BufferedInputStream(fileInput);

            int i = buffInput.read();
            while(i != -1){
                System.out.print((char)i);
                i = buffInput.read();
            }
            buffInput.close();
            fileInput.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
