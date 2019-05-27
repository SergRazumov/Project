import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    private static <T extends Comparable<T>> List<T> merge(List<T> a1, List<T> a2) {
        int ia1 = 0, ia2 = 0;
        List<T> res = new ArrayList<>();
        while (ia1 < a1.size() && ia2 < a2.size()) {
            if (a1.get(ia1).compareTo(a2.get(ia2)) < 0) {
                res.add(a1.get(ia1++));
            } else {
                res.add(a2.get(ia2++));
            }
        }
        if (ia1 == a1.size()) {
            res.addAll(a2.subList(ia2, a2.size()));
        } else {
            res.addAll(a1.subList(ia1, a1.size()));
        }
        return res;
    }

    private static <T extends Comparable<T>> void merge(ArrayList<T> list, int low, int m, int high) {
        List<T> a1 = list.subList(low, m);
        List<T> a2 = list.subList(m, high);
        List<T> res = merge(a1, a2);
        for (int i = low, j = 0; i < high; i++, j++) {
            list.set(i, res.get(j));
        }
    }

    private static <T extends Comparable<T>> void mergeSort(ArrayList<T> list, int low, int high) {
        if(high-low <= 1) return;
        int m = (high+low)/2;
        mergeSort(list, low, m);
        mergeSort(list, m, high);
        merge(list, low, m, high);
    }

    private static ArrayList<Student> readStudents() {
        ArrayList<Student> listStud = new ArrayList<>();
        try (Scanner scan = new Scanner(new File("students.txt"))) {
            scan.useLocale(new Locale("ru", "RU"));
            while (scan.hasNext()) {
                listStud.add(new Student(scan.next(), scan.next(), scan.nextInt(), scan.nextDouble()));
            }
        } catch(IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return listStud;
    }

    public static void main(String[] args) {
        ArrayList<Student> listStud = readStudents();
        System.out.println(listStud);
        Collections.sort(listStud);
        System.out.println(listStud);

        listStud = readStudents();
        System.out.println(listStud);
        listStud.sort(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getAverage()).compareTo(Double.valueOf(o1.getAverage()));
            }
        });
        System.out.println(listStud);

        listStud = readStudents();
        System.out.println(listStud);
        mergeSort(listStud, 0, listStud.size());
        System.out.println(listStud);

    }
}
