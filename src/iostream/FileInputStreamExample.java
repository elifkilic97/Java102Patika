package iostream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileInputStreamExample {
    public static void main(String[] args){
        try {
            FileInputStream input = new FileInputStream("patika.txt");
            input.skip(10);
            //System.out.println(input.read());//ilk elemanın bayt değerini döndürecek (b)nin
            int i = input.read();
            while(i != -1){
                System.out.print((char)i);
                i = input.read();
            }
            input.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
