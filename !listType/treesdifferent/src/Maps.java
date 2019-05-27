import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        Map<String, String> myMap = new TreeMap<>();

        myMap.put("строка 1", "String 1");
        myMap.put("один", "one");
        myMap.put("два", "two");
        myMap.put("три", "Three");
        myMap.put("четыре", "four");
        myMap.put("стол", "table");
        myMap.put("два", "Pair");

        System.out.println(myMap.get("три"));
        System.out.println();
        for (String key : myMap.keySet()) {
            System.out.println(key);
        }
        System.out.println();
        for (String value : myMap.values()) {
            System.out.println(value);
        }
        System.out.println();
        for (Map.Entry<String, String> entry : myMap.entrySet()) {
            System.out.println(entry.getKey() + "; " + entry.getValue());
        }
    }
}
