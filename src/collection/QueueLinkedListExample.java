package collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedListExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // add() metodu ile kuyruğa öğe ekleme (ekleme yapılamazsa hata verir)
        queue.add("Deniz");
        queue.add("Berna");

        // offer() metodu ile kuyruğa öğe ekleme (ekleme yapılamazsa false döner)
        queue.offer("Volkan");
        queue.offer("Çağlar");

        // remove() metodu kuyruğun başındaki değeri verir ve kuyruktan çıkarır
        // Kuyruk boşsa NoSuchElementException hatası fırlatır
        System.out.println("remove() : " + queue.remove());

        // element() metodu kuyruğun başındaki öğeyi verir; kuyruktan çıkarmaz
        // Kuyruk boşsa NoSuchElementException hatası fırlatır
        System.out.println("element() : " + queue.element());

        // poll() metodu kuyruğun başındaki öğeyi verir ve onu kuyruktan çıkarır
        // Kuyruk boşsa null döner
        System.out.println("poll() : " + queue.poll());

        // peek() metodu kuyruğun başındaki öğeyi verir; kuyruktan çıkarmaz
        // Kuyruk boşsa null döner
        System.out.println("peek() : " + queue.peek());

        System.out.println("Kuyruktaki kalan elemanlar: " + queue);

    }
}
