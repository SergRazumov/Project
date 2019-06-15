import javax.lang.model.element.Element;
import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

    public final static MyHashMap myHashMap = new MyHashMap();
    private List<Elem>[] hashMap = new ArrayList[100];

    public void put(String key, int value) {
        int index = Math.abs(key.toLowerCase().hashCode()%100);

        if(hashMap[index] == null) {
            hashMap[index] = new ArrayList<>();
            hashMap[index].add(new Elem(key, value));
        } else if(hashMap[index].) {

        }

            /*
            while (hashMap[index].listIterator().hasNext()) {
                if(key.equals(hashMap[index].listIterator().next().getKey())) {

                }*/
        }
    }
}
