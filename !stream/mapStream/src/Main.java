import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<String> list = readFile();
        Map<Character, Integer> table = countLetterInLine(list);
        view(table);
    }


    private static List<String> readFile() {
        try {
            Stream<String> lines = Files.lines(Paths.get("Text.txt"));
            return lines.map(s -> {
                return s.split("[^А-Яа-я]+"); // фильтр на слова
            })
                    .flatMap(Stream::of)
                    .peek(s -> System.out.println(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    private static void view(Map<Character,Integer> map) {
        for(Map.Entry<Character, Integer> m: map.entrySet()) {
            System.out.print(m.getKey() + " " + m.getValue() + "  ");
        }
    }

    // 1.По заданному тексту составить таблицу (Map<Character, Integer>), в которой каждой гласной букве соответствует количество слов, в которых встречается эта буква. Например, в результате обработки текста “А нынче - погляди в окно: под голубыми небесами” должна получиться таблица
    //{'А'=2, 'Е'=2, 'И'=3, 'О'=4, 'У'=1, 'Ы'=2, 'Э'=0, 'Ю'=0, 'Я'=1, 'Ё'=0}.
    //Большие и маленькие буквы не различаются. Словом считается любая слитная последовательность русских букв [а-яА-ЯёЁ]. Исходный текст считывается из файла на диске.

    private static Map<Character, Integer> countLetterInLine(List<String> list) {

        Collector<String, TreeMap<Character, Integer>, TreeMap<Character, Integer>> collector = Collector.of(
                () -> {
                    TreeMap<Character, Integer> map = new TreeMap<>();
                    Set<Character> letter = new HashSet<>(Arrays.asList('а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я'));
                    for (Character v : letter) map.put(v, 0);
                    return map;
                },
                (TreeMap<Character, Integer> map, String word) -> {
                    Set<Character> letters = new HashSet<>();
                    word = word.toLowerCase();
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                            if (map.keySet().contains(c)) {
                                letters.add(c);
                        }
                    }
                    for (Character let : letters) {
                        map.put(let, map.get(let)+1);
                    }
                },
                (TreeMap<Character, Integer> map1, TreeMap<Character, Integer> map2) -> {
                    for(Map.Entry<Character, Integer> map: map1.entrySet()) {
                       if(map2.containsKey(map.getKey())) map2.put(map.getKey(), map.getValue()+map2.get(map.getKey()));
                    }
                    return map2;
                }, Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT, Collector.Characteristics.IDENTITY_FINISH);
        return list.parallelStream().collect(collector);
    }
}
