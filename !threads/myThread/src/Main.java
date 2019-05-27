public class Main {
    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            int sum = 0;
            for(int i = 1; i< 1_000_000; i++) {
                sum +=i;
            }
            System.out.println(sum);
        });

        Thread th2 = new Thread(() -> {
           for(int i = 0; i< 1_000_000_000; i++) {
               System.out.print(i + " ");
           }
        });

        th1.start();
        th2.start();
        try {
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Доброе утро!");
    }
}
