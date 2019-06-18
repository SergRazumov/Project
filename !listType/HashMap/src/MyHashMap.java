import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyHashMap implements Iterable{

    public final static MyHashMap myHashMap = new MyHashMap();
    private List<Elem>[] hashMap = new ArrayList[10];

    public void put(String key, int value) {
        int index = Math.abs(key.toLowerCase().hashCode() % 10);
        if (hashMap[index] == null) {
            hashMap[index] = new ArrayList<>();
            hashMap[index].add(new Elem(key, value));
        } else if (hashMap[index] != null) {
            for (Elem elem : hashMap[index]) {
                if (elem.getKey().equals(key)) {
                    elem.setValue(value);
                }
            }
            hashMap[index].add(new Elem(key, value));
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }


            /*
            while (hashMap[index].listIterator().hasNext()) {
                if(key.equals(hashMap[index].listIterator().next().getKey())) {

                }*/
}
