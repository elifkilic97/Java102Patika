package iostream;

import java.io.File;
import java.io.IOException;

public class CreateFileExample {
    public static void main(String[] args){

        //File dosya = new File("patika.txt");// "src/patika.txt" de verebilirdik parametre olarak

        /*
        try {
            dosya.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        */

       // System.out.println(dosya.delete());

        File dizin = new File("test");
        //System.out.println(dizin.mkdir());
        String[] liste = dizin.list();

        for(String str : liste)
            System.out.println(str);
    }
}
