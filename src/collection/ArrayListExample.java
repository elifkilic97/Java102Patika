package collection;
import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {

        List<String> nameList = new ArrayList<String>();

        nameList.add("Gamze");
        nameList.add("Elif");
        nameList.add("Mustafa");
        nameList.add("Umut");
        nameList.add("Umut");
        nameList.add(null);

        System.out.println(nameList); //[Gamze, Elif, Mustafa, Umut, Umut, null]

        System.out.println("Size of list: " + nameList.size()); // Size of list: 6

        System.out.println("Element of 1 index: " + nameList.get(1)); //Element of 1 index: Elif
        System.out.println("Element of 2 index: " + nameList.get(2)); //Element of 2 index: Mustafa

        System.out.println("Index of 'Umut': " + nameList.indexOf("Umut")); //Index of 'Umut': 3
        System.out.println("Index of 'Umut': " + nameList.lastIndexOf("Umut")); //Index of 'Umut': 4

        nameList.add(3, "Zeynep"); //["Gamze", "Elif", "Mustafa", "Zeynep", "Umut", "Umut", null] Zeynep 3. indekse yerleştirilir, sonrası kayar:

        nameList.set(1, "Naz"); //["Gamze", "Naz", "Mustafa", "Zeynep", "Umut", "Umut", null] indisteki "Elif" → "Naz" olarak değiştirilir:

        System.out.println(nameList.contains("Elif")); //false
        System.out.println(nameList.contains("Mustafa")); //true

        // silinen değer fonksiyondan bize geri döndürülür.
        String firstElement = nameList.remove(0); //["Naz", "Mustafa", "Zeynep", "Umut", "Umut", null] Gamze silinir.
        System.out.println(firstElement + " is removed from list!"); //Gamze is removed from list!

        List<String> newNameList = new ArrayList<String>();
        newNameList.add("Batuhan");
        newNameList.add("Kemal");

        // bir listeyi tümüyle bir diğer listeye eklemek için "addAll" fonksiyonu kullanılır.
        nameList.addAll(newNameList); //["Naz", "Mustafa", "Zeynep", "Umut", "Umut", null, "Batuhan", "Kemal"]


        // listeden alt bir liste oluşturmak için "sublist" fonksiyonunu kullanırız.
        //Başlangıç ve bitiş indisleri verilir.
        //Başlangıç indisindeki eleman dahil, bitiş indisindeki eleman hariç yeni bir liste oluşturulur.
        List<String> subList = nameList.subList(4, 6); //["Umut", null] 4. ve 5. indeksler

        System.out.println("Sublist from name list");
        System.out.println(subList); //Sublist from name list  [Umut, null]

        // toArray fonksiyonu parametresiz çağırırsak Object tipinde bir dizi döner.
        Object[] objectArray = nameList.toArray();

        // toArray fonksiyonuna hangi tipte bir dizi oluşturmak istiyorsak,
        // o tipten bir nesne üretip parametre olarak göndeririz.
        // String tipinden bir dizi almak istediğimiz için "new String[0]" şeklinde bir nesne üretip, "toArray" fonksiyonuna gönderdik.
        String[] stringArray = nameList.toArray(new String[0]);

        // listedeki tüm elemanları temizler. yani tümünü listeden siler.
        nameList.clear();
    }
}