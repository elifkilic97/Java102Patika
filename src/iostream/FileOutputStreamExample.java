package iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[]args){
        String yazi = "\nOutputStream ogreniyorum\nPatika Dev";
        try {
            FileOutputStream output = new FileOutputStream("patika.txt", true); //burayı true yapmazsak
            // içindeki verileri silip yeni eklediğimiz verileri ekliyor.
            byte[] yaziByte = yazi.getBytes();
            output.write(yaziByte);
            output.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
