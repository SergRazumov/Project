package lines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadList {
    private static class Task {
        int number;
        String[] words;

        Task(int number, String[] words) {
            this.number = number;
            this.words = words;
        }

        @Override
        public String toString() {
            return String.format("%2d) %s", number, Arrays.toString(words));
        }
    }

    Predicate<String> f(String s) {
        return new Predicate<String>() {
            public boolean test(String o) {
                return o.equals(s);
            }
        };
    }

    public static void main(String[] args) {
        List<Task> tasks = null;
        try (Stream<String> lines = Files.lines(Paths.get("src/lines", "list.txt"))) {
            tasks = lines
                    .filter(s -> s.matches("^\\d+\\.(\\s*[а-яА-ЯёЁ]\\s*)+$"))
                    //.filter(Predicate.isEqual("1. Главное дело"))
                    .map(s -> {
                        String[] parts = s.split("\\.");
                        return new Task(Integer.parseInt(parts[0]), parts[1].trim().split("\\s+"));
                    })
                    .collect(Collectors.toList());
        } catch(IOException e) {
            System.out.println("File not found");
        }
        tasks.stream().sorted(Comparator.comparingInt(t -> t.number)).forEach(System.out::println);

        Map<Integer, String> map = tasks.parallelStream().collect(Collectors.toMap(t->t.number, t->t.words[0], (s1, s2) -> s1 + " " + s2));
        System.out.println(map);
    }
}
