import java.util.*;

public final class Iterators {
    public static <T> Iterator<T> unitIterator(T e) {
        return new Iterator<T>() {
            boolean flag = true;

            @Override
            public boolean hasNext() {
                return flag;
            }

            @Override
            public T next() {
                if (!flag) throw new NoSuchElementException();
                flag = false;
                return e;
            }
        };
    }

    public static <T> Iterator<T> combine(Iterator<T> it1, Iterator<T> it2) {
        return new Iterator<T>() {
            Iterator<T> current = it1;

            @Override
            public boolean hasNext() {
                if (current.hasNext()) return true;
                if (current == it1) current = it2;
                return current.hasNext();
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return current.next();
            }
        };
    }

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 8);
        for (Iterator<Integer> it = combine(list1.iterator(), list2.iterator()); it.hasNext(); ) {
            System.out.println(it.next());
        }

    }
}
