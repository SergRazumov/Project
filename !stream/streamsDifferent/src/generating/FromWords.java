package generating;

import java.util.stream.Stream;

public class FromWords {
    private static String s1 = "мой дядя самых честных правил";
    private static String s2 = "a quick   brown fox   jumps over the lazy dog";

    public static void main(String[] args) {
        Stream.of(s1.split("\\s+")).sorted().forEach(w -> { System.out.print(w + ' '); });
        System.out.println();
        Stream.of(s2.split("\\s+")).sorted().forEach(System.out::println);
    }
}
