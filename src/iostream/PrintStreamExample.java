package iostream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args){
        try {
            PrintStream output = new PrintStream("print.txt");
            output.print("123" + 222);
            output.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
