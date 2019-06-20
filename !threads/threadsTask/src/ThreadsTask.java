import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadsTask {
    static AtomicInteger num = new AtomicInteger(0);


    public static void main(String[] args) {
        List<Runnable> task = new ArrayList<>();
        for(int i =0; i<=100; i++) {
            task.add(() -> {
                num.addAndGet(1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                System.out.print("Ура!");
            });
        }
        task.parallelStream().forEach((t) -> {t.run();});
        /*
        for(Runnable t: task) {
            t.run();
        }
        */
    }
}
