package generating;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class FromCollection {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 2, 5, 4, 7, 2, 7, 8, 1);
        Stream<Integer> s = list.stream();
        s.sorted().forEach(System.out::println);
        System.out.println();
        Set<Integer> set = new HashSet<>(list);
        s = set.stream();
        s.parallel().forEach(System.out::println);
    }
}
