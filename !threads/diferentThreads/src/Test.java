public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <=100000000; i++) sum += i;
            System.out.println(sum);
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) System.out.println(i);
        });
        Runnable r1 = () -> {};
        Thread t3 = new Thread(r1);


        t1.start();
        t2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
        System.out.println("Finish");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }
    }
}
