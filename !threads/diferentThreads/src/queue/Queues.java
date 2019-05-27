package queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Queues {
    static List<Integer> queue = Collections.synchronizedList(new LinkedList<>());

    static Thread writer = new Thread(() -> { for (int i = 0; i < 1000; i++) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        queue.add(i);
    }}, "writer");
    static Thread reader = new Thread(() -> {
        int s = 0;
        for (int i = 0; i < 1000; i++) {
            while(true) { if (!queue.isEmpty()) break; }
            s += queue.remove(0);
    }}, "reader");

    public static void main(String[] args) {
        writer.start();
        reader.start();
        try {
            writer.join();
            reader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ура! Конец!");
    }
}
