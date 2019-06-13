package vowels;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('А', 'Е', 'О', 'Ю', 'Я', 'Э', 'И', 'Ё', 'У', 'Ы'));

    private static Set<Character> setOfVowels(String word) {
        Set<Character> setOfVowels = new HashSet<>();
        for (char c : word.toUpperCase().toCharArray()) {
            if (VOWELS.contains(c)) {
                setOfVowels.add(c);
            }
        }
        return setOfVowels;
    }

    private static Map<Character, Long> emptyMap() {
        Map<Character, Long> emptyMap = new HashMap<>();
        for (char c : VOWELS) emptyMap.put(c, 0L);
        return emptyMap;
    }

    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src/vowels", args[0]))) {
            Map<Character, Long> emptyMap = emptyMap();
            emptyMap.putAll(lines.parallel()
                    .flatMap(line -> Stream.of(line.split("[^а-яА-ЯёЁ]+")))
                    .flatMap(w -> setOfVowels(w).stream())
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
            System.out.println(emptyMap);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
