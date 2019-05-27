import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class MyList<T> implements Iterable<T>, Comparable<MyList<T>> {

    int elements;

    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    @Override
    public int compareTo(MyList<T> o) {
        return 0;
    }

    private static class Element<Tp> {
        Tp info;
        Element<Tp> next;

        public Element(Tp info, Element<Tp> next) {
            this.info = info;
            this.next = next;
        }
    }

    private class ListIterator implements Iterator<T> {
        Element<T> curElement = first;

        @Override
        public boolean hasNext() {
            return curElement != null;
        }

        @Override
        public T next() {
            T info = curElement.info;
            curElement = curElement.next;
            return info;
        }
    }

    private Element<T> first = null;

    public void add(T a) {
        Element<T> newElem = new Element<T>(a, first);
        first = newElem;
        elements++;
    }

    public int size() { return elements; }

    /**
     * Перебирает элементы списка, выполняя над каждым определенное действие
     * @param action    Это действие
     */
    public void view(Consumer<T> action) {
        for(Element<T> current = first; current != null; current = current.next) {
            action.accept(current.info);

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Element<T> current = first; current != null; current = current.next) {
            sb.append(current.info);
            if (current.next != null) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void reverse() { //перевернуть массив
        Element<T> current = first;
        Element<T> newList = null;
        while (current != null ) {
            Element<T> next = current.next;
            current.next = newList;
            newList = current;
            current = next;
        }
        first = newList;
    }

    private Element<T> getElement(int index) {
        if (index < 0 || index > elements) {
            throw new IndexOutOfBoundsException("Неверный индекс в списке " + index);
        }
        Element<T> current = first;
        for (int j = 0; j < index; ++j) {
            current = current.next;
        }
        return current;
    }

    public T get(int number) { //получаем значение элемента по индексу
        Element<T> current = getElement(number);
        return current.info;

    }

    public void set(int index, T value) { //записываем значение number по индексу
        Element current = getElement(index);
        current.info = value;
    }

    public T last() { //выдать значение последнего элемента
        Element<T> current = getElement(elements-1);
        return current.info;
    }

    public T first() { //выдать значение первого элемента
        Element<T> current = getElement(0);
        return current.info;
    }

    public T remove(int index) {
        T delNumber;
        if (index == 0) {
            delNumber = first.info;
            first = first.next;
            // current.next = null;
            elements--;
            return delNumber;
        }
        Element<T> current = getElement(index-1);
        delNumber = current.next.info;
        current.next = current.next.next;
        elements--;
        return delNumber;
    }

    public Object[] toArray() {
        Object[] num = new Object[elements];
        Element<T> current = first;
        for (int i = 0; i < num.length; i++) {
            num[i] = current.info;
            current = current.next;
        }
        return num;
    }

    public int find(T n) {
        Element<T> current = first;
        for (int i = 0; i < elements; i++) {
            if (current.info.equals(n)) return i;
            current = current.next;
        }
        return -1;
    }

    public void insert(int index, T value) {

        if (index == 0) {
            add(value);
            return;
        }
        Element<T> current = getElement(index-1);
        Element<T> newElem = new Element<T>(value, current.next);
        current.next = newElem;
        elements++;
    }
}
