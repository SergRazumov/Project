import java.util.Iterator;

import java.util.Random;

public class ThreadQueue<Thread> implements Iterable<Thread>{

    for(int i =0; i<=10; i++) {
       Thread write = new java.lang.Thread(()-> { Random rnd = new Random();
            int time = rnd.nextInt(1000);
            try {
                java.lang.Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }});
        task.add(write);
    }

    @Override
    public Iterator<Thread> iterator() {
        return new Iterator<Thread>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Thread next() {
                return null;
            }
        };
    }
}
