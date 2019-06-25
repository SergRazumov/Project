import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadsTask {

    private static int numberTask = 10;

    public static void main(String[] args) {

        List<Thread> tasks = new ArrayList<>();

        Thread read = new Thread(() -> {
            int cnt = 0;
            while (true) {
                synchronized (tasks) {
                    try {
                        while (tasks.isEmpty()) {
                            tasks.wait();
                        }
                        tasks.get(0).start();
                        tasks.remove(0);
                        cnt++;
                        tasks.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if(cnt==numberTask) break;
            }
        });
        read.start();

        for (int i = 0; i < numberTask; i++) {
            Random rnd = new Random();
            int count = rnd.nextInt(1000);
            try {
                Thread.sleep(count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread write = new Thread(() -> {
                System.out.println("Задача выполнена!");
            });
            synchronized (tasks) {
                try {
                    while (tasks.size() >= 3) tasks.wait();
                } catch (InterruptedException e) {
                }
                tasks.add(write);
                tasks.notifyAll();
            }
        }
        try {
            read.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

