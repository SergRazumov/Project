package deadlock;

public class Main {
    final static Object lock1 = new Object();
    final static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                synchronized(lock1) {
                    synchronized(lock2) {

                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                synchronized(lock1) {
                    synchronized(lock2) {

                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
