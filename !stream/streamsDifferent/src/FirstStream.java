import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FirstStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) list.add(i);

        Stream<Double> d = list.stream().filter(n -> n % 3 == 0).map(x -> x + 0.5);
        Optional<Double> o = d.max(Comparator.naturalOrder());
        System.out.println(o.get());
    }
}
