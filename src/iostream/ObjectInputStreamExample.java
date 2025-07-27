package iostream;

import java.io.*;

public class ObjectInputStreamExample {
    public static void main(String[] args){
        Car c1 = new Car("Audi", "A3");

        try {
            FileInputStream inputFile = new FileInputStream("araba.txt");
            ObjectInputStream inputStream = new ObjectInputStream(inputFile);
            Car newCar = (Car) inputStream.readObject();
            System.out.println(newCar.getBrand());
            System.out.println(newCar.getModel());
            inputFile.close();
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
