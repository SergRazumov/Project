import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    /**
     * "Внешний класс" созданный для хранения информации для формирования классов находящихся в Graph
     */
    private static class ExternalRoad {
        String from;
        String to;
        int length;

        public ExternalRoad(String from, String to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
        }
    }

    /**
     * Читаем из файла, формируем множество cityNames из городов, создаем объекты ExternalRoad и каждый объект храним в списке roads, создаем объект Graph передаем ему множество из городов, запускаем метод
     * addRoad для графа.
     * @param fileName путь к читаемому файлу
     * @return возвращаем сформированный graph с
     */


    public static Graph readFile(String fileName) {
        List<ExternalRoad> roads = new ArrayList<>();
        Set<String> cityNames = new HashSet<>();
        try (Scanner sc = new Scanner(new File(fileName))) {
            sc.useDelimiter("\\s+");
            while (sc.hasNext()) {
                String from = sc.next();
                String to = sc.next();
                int length = sc.nextInt();
                cityNames.add(from);
                cityNames.add(to);
                roads.add(new ExternalRoad(from, to, length));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
        Graph graph = new Graph(cityNames);
        for (ExternalRoad road : roads) { //перебирая объекты в списке roads передаем их содержимое в метод addRoad;
            graph.addRoad(road.from, road.to, road.length);
        }
        return graph;
    }

    /**
     * Отсюда запуск!
     * @param args то что передает Java машина для запуска
     */

    public static void main(String[] args) {
        Graph g = readFile(args[0]);
        System.out.println(g.minPath("G", "A"));
        g = readFile(args[1]);
        System.out.println(g.minPathHeavy("C", "E"));
    }
}
