import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap implements Iterable<Elem<String, Integer>>{

    public final static MyHashMap myHashMap = new MyHashMap();
    private List<Elem<String, Integer>>[] hashMap = new ArrayList[10];

    public void put(String key, int value) {
        int index = Math.abs(key.toLowerCase().hashCode() % 10);
        if (hashMap[index] == null) {
            hashMap[index] = new ArrayList<>();
            hashMap[index].add(new Elem<>(key, value));
        } else if (hashMap[index] != null) {
            for (Elem<String, Integer> elem : hashMap[index]) {
                if (elem.getKey().equals(key)) {
                    elem.setValue(value);
                    return;
                }
            }
            hashMap[index].add(new Elem<>(key, value));
        }
    }

    @Override
    public Iterator<Elem<String, Integer>> iterator() {
        return new Iterator<>() {
            Iterator<Elem<String, Integer>> current = null;
            int i = 0;

            {
                if (current == null) {
                    while (i < hashMap.length) {
                        if (hashMap[i] != null) {
                            current = hashMap[i].iterator();
                            break;
                        }
                        i++;
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return i != hashMap.length;
            }

            @Override
            public Elem<String, Integer> next() {
                if (!hasNext()) throw new IllegalStateException();
                Elem<String, Integer> retElem = current.next();
                if (!current.hasNext()) {
                    while (++i < hashMap.length) {
                        if (hashMap[i] != null) {
                            current = hashMap[i].iterator();
                            break;
                        }

                    }
                }
                return retElem;
            }
        };
    }
}
