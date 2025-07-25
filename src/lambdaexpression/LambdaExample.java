package lambdaexpression;

public class LambdaExample {
    public static void main(String[] args){
        Runnable r1 = new Runnable() {
            @Override
            public void run()
            {
                System.out.println("r1 sınıfı");
            }
        };
        r1.run();

        Runnable r2 = () -> System.out.println("r2 sınıfı");
        r2.run();

        Runnable r3 = () -> {
            System.out.println("r3 sınıfı");
        };
        r3.run();
    }
}



