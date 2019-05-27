import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class CompareLists {
    private static class Student implements Comparable<Student> {
        private final String name;
        private final double average;
        private final int group;

        public Student(String name, double average, int group) {
            this.name = name;
            this.average = average;
            this.group = group;
        }

        public String getName() {
            return name;
        }

        public double getAverage() {
            return average;
        }

        public int getGroup() {
            return group;
        }

        @Override
        public String toString() {
            return "[" + name + " " + group + " " + average + "]";
        }

        @Override
        public int compareTo(Student o) {
            return name.compareTo(o.name);
        }
    }

    private static class MyClass implements Consumer<Student> {
        public StringBuilder sb = new StringBuilder();

        @Override
        public void accept(Student t) {
            sb.append(t.name).append(" ");
        }
    }

    public static void main(String[] args) {
        List<Student> studs = Arrays.asList(
            new Student("Иванов", 3.5, 443),
            new Student("Петров", 4.8, 232),
            new Student("Сидоров", 4.1, 234),
            new Student("Александров", 4.9, 232)
        );

        for (Student s : studs) {
            System.out.println(s);
        }

        studs.forEach(System.out::println);
        System.out.println();

        Collections.sort(studs);
        studs.forEach(System.out::println); //до двоеточия статический класс или new Object, после идет метод имя
        studs.forEach(x -> { System.out.println(x); }); //х это аргумент, или список аргументов, справа тело функции
        System.out.println();
        MyClass my = new MyClass();
        studs.forEach(my);
        System.out.println(my.sb);

        StringBuilder sb1 = new StringBuilder();
        studs.forEach(t -> sb1.append(t.name).append(" "));
        System.out.println(sb1);


        Collections.sort(studs, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o2.compareTo(o1);
            }
        });
        Collections.sort(studs, (o1, o2) -> o2.compareTo(o1));
        studs.forEach(System.out::println);
        System.out.println();
    }
}
