package priorityqueue;

public class PriorQueue<T extends PrioQueueElement> implements PriorityQueque<T> {

    T[] queue;
    int size = 0;

    public PriorQueue(int length) {
        queue = (T[])new Object[length];
    }

    @Override
    public void addElement(T t) {
        queue[size] = t;
        t.setIndexQueue(size);
        raisePriority(t);
        size++;
    }

    @Override
    public T removeMin() {
        int k = 0;
        T returnT = queue[0];
        queue[0] = queue[size - 1];
        queue[--size] = null;
        while (2*k <= size) {
            int son = 2*k + 1;
            if (son + 1 <size) {
                if (queue[son+1].getDistance() < queue[son].getDistance()) son++;
            }
            if (returnT.getDistance() > queue[son].getDistance()) {
                queue[k] = queue[son];
                queue[k].setIndexQueue(k);
            }
        }
        queue[k] = returnT;
        returnT.setIndexQueue(k);
        return returnT;
    }

    @Override
    public void raisePriority(T t) {
        int i = t.getIndexQueue();
        while (i > 0) {
            int p = (i-1) / 2;
            if (queue[p].getDistance() > t.getDistance()) {
                queue[i] = queue[p];
                queue[i].setIndexQueue(i);
            } else {
                break;
            }
        }
        queue[i] = t;
        t.setIndexQueue(i);
    }

    @Override
    public boolean isEmpty() {
        return queue[0] == null;
    }
}
