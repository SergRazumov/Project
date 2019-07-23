import java.util.Map;

public class MyMap {

    private Map<Integer, String> map;

    public MyMap(Map<Integer, String> map) {
        this.map = map;
    }

    public void addValue() {
        for(Map.Entry<Integer, String> entry:map.entrySet()) {
            System.out.println(entry.getKey() + "; " + entry.getValue());
        }
    }
}
