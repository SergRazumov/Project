public interface PriorityQueque<T> {

    void addElement(T t);

    T removeMin();

    void changePriority (T t);

    boolean isEmpty();
}
