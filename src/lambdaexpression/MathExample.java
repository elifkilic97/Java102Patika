package lambdaexpression;

public class MathExample {
    public static void main(String[] args){
        Math add1 = new Math(){
            @Override
            public int transaction(int a, int b)
            {
                return a + b;
            }
        };

        System.out.println(add1.transaction(10, 20));

        //ctorda alacağı parametreleri ortadaki paranteze yazıyoruz.
        Math add2 = (a, b) -> a + b;

        System.out.println(add2.transaction(50, 20));
    }
}
