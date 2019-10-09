package modernjavainaction.chap03;

public class RunnableTest {
    public static void main(String[] args) {
        Runnable r1 = ()-> System.out.println("Hello world1");
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hellow orld2");
            }
        };
        process(r1);
        process(r2);
        process(()-> System.out.println("Hello world3"));

    }

    static void process(Runnable runnable){
        runnable.run();
    }
}


