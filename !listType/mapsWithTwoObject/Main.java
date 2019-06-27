package maps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Car, BigDecimal> map = new HashMap<>();
        map.put(new Car("Toyota", 160), new BigDecimal("1500000"));
        map.put(new Car("KIA", 160), new BigDecimal("1500000"));
        map.put(new Car("Mercedes", 160), new BigDecimal("2000000"));
        map.put(new Car("Huinday", 160), new BigDecimal("1100000"));
        map.put(new Car("Honda", 160), new BigDecimal("1000000"));

        Car toyota = new Car("Toyota", 160);
        System.out.println(map.get(toyota));
    }
}
