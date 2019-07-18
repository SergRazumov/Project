import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class City {

    private String name;
    private List<Integer> randomValue;

//    public City() {
//    }

    public City(@Value("spb") String name, @Value("#{'2,1'.split(',')}") List<Integer> randomValue) {
        this.name = name;
        this.randomValue = randomValue;
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRandomValue(List<Integer> randomValue) {
        this.randomValue = randomValue;
    }
}
