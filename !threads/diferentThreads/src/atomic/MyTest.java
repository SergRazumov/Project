package atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyTest {
    static AtomicInteger ii = new AtomicInteger(0);

    public static void main(String[] args) {
        List<Runnable> listR = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listR.add(() -> {
                for (int k = 0; k < 10000; k++) {
                    int n;
                    do {
                        n = ii.get();
                        if (ii.compareAndSet(n, n + 10)) break;
                    }
                    while (true);
                }
            });
        }
        listR.parallelStream().forEach(r -> r.run());




        //Counter c = new Counter();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(new Thread(()->{ for (int k = 0; k < 10000; k++) {
                int n;
                do {
                    n = ii.get();
                    if (ii.compareAndSet(n, n+10)) break;
                }
                while (true) ;
        }}));
        for (Thread t : list) t.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println(ii);
    }
}
