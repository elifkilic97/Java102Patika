package collection;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args){
        HashSet<String>  h = new HashSet<>();
        h.add("a");
        h.add("b");
        h.add("c");
        h.add("null");

        System.out.println("set boyutu: " + h.size());

        for(String s : h)
            System.out.println(s);

        System.out.println("b elemanını içeriyor mu?: " + h.contains("b"));

        h.remove("b");

        System.out.println("b elemanını içeriyor mu?: " + h.contains("b"));

        h.clear();

        System.out.println("--------------------------------------");
        for(String s : h)
            System.out.print(s);
        System.out.println("--------------------------------------");
    }
}
