package mapinterface;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {

        HashMap<String, String> capitalCities = new HashMap<>();

        // Anahtar-değer (key-value) çiftleri ekleniyor
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        System.out.println("Tüm şehirler: " + capitalCities);

        // Belirli bir anahtarın değerini al
        String englandCapital = capitalCities.get("England");
        System.out.println("England'ın başkenti: " + englandCapital);

        // Belirli bir anahtar-değer çifti silinir
        capitalCities.remove("England");

        System.out.println("Eleman sayısı: " + capitalCities.size());

        // Anahtarları yazdır
        for (String key : capitalCities.keySet())
            System.out.println("Anahtar: " + key);

        // Değerleri yazdır
        for (String value : capitalCities.values())
            System.out.println("Değer: " + value);

        // Anahtar ve değerleri birlikte yazdır
        for (String key : capitalCities.keySet())
            System.out.println("Key: " + key + " | Value: " + capitalCities.get(key));

        // HashMap temizleniyor
        capitalCities.clear();
    }

}
