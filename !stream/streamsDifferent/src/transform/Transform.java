package transform;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

public class Transform {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("src/transform", "transactions.txt"))) {
            lines.map(s -> s.split("\\s+"))
                    .map(ss -> new Transaction(ss[0], ss[1].equals("C"), Double.parseDouble(ss[2])))
                    .filter(t -> t.isCredit())
                    .sorted(Comparator.comparingDouble(t -> -t.getAmount()))
                    .limit(1)
                    .forEach(t -> System.out.println(t.getName()));
        } catch(IOException e) {
            System.out.println("File not found");
        }
    }
}
