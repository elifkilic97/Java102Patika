package streamapi;

import java.util.*;
import java.util.stream.*;

public class StreamApiExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(32, 6, 8, 9, 10, 120);

        list.stream() // 1. Stream oluştur
                .filter(sayi -> sayi % 2 == 0) // 2. filtrele
                .map(sayi -> sayi * sayi) // 3. karesini al
                .sorted() // 4. sırala
                .forEach(System.out::println); // 5. yazdır (terminal işlem)

        // 1. forEach – yazdır
        //list.stream().forEach(System.out::println);

        // 2. collect – listeye çevir
        List<Integer> kareler = list.stream()
                .map(x -> x * x)
                .collect(Collectors.toList());

        // 3. count – kaç eleman var
        long adet = list.stream().count();
        System.out.println(adet);

        // 4. reduce – toplama yap
        int toplam = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(toplam);

        // 5. anyMatch – 100'den büyük var mı
        boolean varMi = list.stream().anyMatch(x -> x > 100);
        System.out.println(varMi);

        // 6. findFirst – ilk elemanı al
        Optional<Integer> ilk = list.stream().findFirst();
        System.out.println(ilk);

    }
}
