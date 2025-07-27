package iostream;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayInputStreamExample {
    public static void main(String[] args){
        byte[] dizi = {1, 2, 3, 5, 54, 66};
        ByteArrayInputStream input = new ByteArrayInputStream(dizi);
        System.out.println("Kullanılabilen byte sayısı: " + input.available());
        input.skip(2);
        int i = input.read();
        while(i != -1){
            System.out.println(i);
            i = input.read();
        }
        try {
            input.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
