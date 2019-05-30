import java.util.*;

public class Graph {

    /**
     * Каждый объект City содержит имя города и список дорог
     */
    private static class City {
        String name;
        List<Road> roads = new ArrayList<>();

        City(String name) {
            this.name = name;
        }
    }

    /**
     * Каждый объект Road содержит длину пути и номер города назначения
     */
    private static class Road {
        int length;
        int endCity;

        Road(int length, int endCity) {
            this.length = length;
            this.endCity = endCity;
        }
    }

    /**
     * То из чего состоит объет Graph:
     *
     * @param cities фиксированный массив с индексами из объектов City
     * @param cityMap хэш-список содержащий в виде ключа город, а в виде значения числа от 0 до n (городов)
     */

    private final City[] cities;
    private final Map<String, Integer> cityMap;

    /**
     * @param cityNames множество из городов
     */
    public Graph(Set<String> cityNames) {
        cities = new City[cityNames.size()];
        cityMap = new HashMap<>();
        int i = 0;
        for (String cityName : cityNames) {
            cities[i] = new City(cityName);
            cityMap.put(cityName, i);
            i++;
        }
    }

    /**
     * fromNumber получаем число по ключу в cityMap указанного в качестве города отправления
     * toNumber получаем число по ключу в cityMap  указанного в качестве города назначения
     * Теперь необходимо создать связь между этими точками, мы берем город по индексу отправления, и в его список roads добавляем новый объект Road с длиной и номером города назначения;
     *
     * @param from   город отправления
     * @param to     город назначения
     * @param length длина пути
     */
    public void addRoad(String from, String to, int length) {
        int fromNumber = cityMap.get(from);
        int toNumber = cityMap.get(to);
        cities[fromNumber].roads.add(new Road(length, toNumber));
    }

    //TODO: 1. В интерфейсе Queue нет метода pop(), как обойтись без приведения greys к типу LinkedList<Integer> ? Посмотрите, какие методы используются в Queue.    (сделано)
    // 2.Метод contains работает не очень быстро, если коллекция содержит много элементов. Можно ли определять цвета вершин быстрее, не обращаясь часто к методу contains? (не понял в каком месте)
    // * 3.На каждом шаге основного цикла используется cityMap.get(v). Хотя для HashMap это и работает быстро, но ведь значение-то одно и то же всегда, надо бы тут оптимизировать. (сделано)
    // * 4.В случае ошибки в задании города в вызове метода minPath программа ломается. Надо бы, чтобы в этом случае возбуждался IllegalArgumentException. (сделано)
    // * 5. Если пути между заданными городами не существует (граф несвязный) программа тоже ломается. Как сделать так, чтобы в этом случае метод minPath выдавал null? (не успел реализовать, думаю стоит обсудить) // ведь в случае отсуствия связи )

    /**
     * @param u название города отправления
     * @param v название города прибытия
     * @return
     */
    public List<String> minPath(String u, String v) {
        if (cityMap.get(u) == null || cityMap.get(v) == null) throw new IllegalArgumentException();
        // 1. Инициализация
        Set<Integer> blacks = new HashSet<>();
        Queue<Integer> greys = new LinkedList<>();
        List<String> city = new ArrayList<>();
        greys.add(cityMap.get(u));
        int[] tree = new int[cities.length];
        Arrays.fill(tree, -1);
        int from = cityMap.get(v);
        // 2. Волна
        while (!greys.contains(from) && !greys.isEmpty()) { // **
            Integer a = greys.poll();
            blacks.add(a);
            for (Road road : cities[a].roads) {
                if (!greys.contains(road.endCity) && !blacks.contains(road.endCity)) {
                    greys.offer(road.endCity);
                    tree[road.endCity] = a;
                }
            }
        }
        if(greys.isEmpty()) return null;
        // 3. Построение пути
        city.add(v);
        while (!city.contains(u)) {
            int to = tree[from];
            city.add(cities[from].name);
            from = to;
        }
        return city;
    }
}
