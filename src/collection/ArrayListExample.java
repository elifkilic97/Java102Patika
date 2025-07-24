package collection;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Bir ArrayList oluştur
        ArrayList<String> fruits = new ArrayList<>();

        // Elemanlar ekle
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Listeyi yazdır
        System.out.println("Meyveler: " + fruits);

        // Belirli bir elemana eriş
        System.out.println("İlk meyve: " + fruits.get(0));

        // Bir elemanı sil
        fruits.remove("Banana");
        System.out.println("Güncel Meyveler: " + fruits);

        // Liste boyutu
        System.out.println("Liste uzunluğu: " + fruits.size());
    }
}
