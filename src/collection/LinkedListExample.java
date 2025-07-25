package collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
        public static void main(String[] args) {

            List<String> nameList = new LinkedList<>();

            nameList.add("Hale");
            nameList.add("Jale");
            nameList.add("Lale");
            nameList.add("Ahmet");
            nameList.add("Mehmet");
            nameList.add("Kemal");

            System.out.println("2. indeksteki eleman: " + nameList.get(2));

            ((LinkedList<String>) nameList).addFirst("Naz");

            ((LinkedList<String>) nameList).addLast("Ümit");

            System.out.println("Güncel liste: " + nameList);
        }

}
