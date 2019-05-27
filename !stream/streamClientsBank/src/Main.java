import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Manipulation> manipulation = readFile();
        Map<String, Double> clients = makeClients(manipulation);
        System.out.println(clients);
    }
/*
    private static void readFile(List<Manipulation> manipulation) {
        try {
            Scanner scanner = new Scanner(new File("Clients.txt"));
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] str = line.split(" ");
                manipulation.add(new Manipulation(str[0], str[1], str[2]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
*/

    private static List<Manipulation> readFile() {
        try (Stream<String> lines = Files.lines(Paths.get("Clients.txt"))) {
            List<Manipulation> manipulation = lines.filter(s -> s.matches("[а-яА-ЯёЁ]+\\s[СД]\\s[0-9]+.[0-9]+"))
                    .peek(s -> System.out.println(s))
                    .map(s -> {
                        String[] parts = s.split(" ");
                        return new Manipulation(parts[0], parts[1], parts[2]);
                    })
                    .collect(Collectors.toList());
            return manipulation;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
/*
Далее, чтобы положить в Map новое значение, используется put или putIfAbsent. Если вы хотите изменить значение, связанное с данным ключом, то надо сначала извлечь его из Map'а с помощью get,
изменить вытащенное значение, а потом положить обратно с помощью put. Разумеется, это все можно проделывать для любого количества имен.
Конечно, коллектор Collectors.toMap делает эту работу несколько более изящно и эффективно (особенно, если использовать parallelStream), но это довольно сложно.
 */


    private static Map<String, Double> makeClients(List<Manipulation> manipulation) {
        Collector<Manipulation, HashMap<String, Double>, HashMap<String, Double>> collector = Collector.of(
                () -> new HashMap<String, Double>(),
                (HashMap<String, Double> map, Manipulation man) -> {
                    if (map.containsKey(man.getName())) {
                        if (man.getStatus() == Status.CREDIT)
                            map.put(man.getName(), map.get(man.getName()) - man.getMoney());
                        else map.put(man.getName(), map.get(man.getName()) + man.getMoney());
                    } else {
                        if (man.getStatus() == Status.CREDIT) map.put(man.getName(), -man.getMoney());
                        else map.put(man.getName(), man.getMoney());
                    }
                },
                (HashMap<String, Double> map1, HashMap<String, Double> map2) -> {
                    for (Map.Entry<String, Double> entry : map1.entrySet()) {
                        if (map2.containsKey(entry.getKey()))
                            map2.put(entry.getKey(), entry.getValue() + map1.get(entry.getKey()));
                        else map2.put(entry.getKey(), entry.getValue());
                    }
                    return map2;
                },
                Collector.Characteristics.UNORDERED, Collector.Characteristics.CONCURRENT, Collector.Characteristics.IDENTITY_FINISH);
        return manipulation.parallelStream().collect(collector); //Не понимаю какие параметры toMap для форммирания готовых клиентов из list....
    }



/*
    private static void makeClients(Map<String, Integer> clients, List<Manipulation> manipulation) {//как действовать если имен много? По хорошему нужно чтобы по ключу шла запись о денежных средствах в Map, но если ключи совпадают то значение заменяется на новое...
        int a = 0, b = 0, p = 0;
        for (Manipulation line : manipulation) {
            if (line.getName().equals("Алексей")) {
                if (line.getStatus().equals(Status.CREDIT)) a -= line.getMoney();
                else a += line.getMoney();
            }
            if (line.getName().equals("Вася")) {
                if (line.getStatus().equals(Status.CREDIT)) b -= line.getMoney();
                else b += line.getMoney();
            }
            if (line.getName().equals("Петя")) {
                if (line.getStatus().equals(Status.CREDIT)) p -= line.getMoney();
                else p += line.getMoney();
            }
        }
        clients.put("Алексей", a);
        clients.put("Вася", b);
        clients.put("Петя", p);
    }
*/
}
