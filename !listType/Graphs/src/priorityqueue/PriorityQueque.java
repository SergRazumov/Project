package priorityqueue;

public interface PriorityQueque<T> {

    void addElement(T t);

    T removeMin();

    void raisePriority (T t);

    boolean isEmpty();
}
