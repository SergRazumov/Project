import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ready {

    /**
     * Заполняет массив оценок значениями от 2 до 5
     * @param value количество оценок
     * @return массив оценок, где последнее значение пустое, чтобы добавить туда оценку
     */

    private static int[] mark(int value) {
        int marks[] = new int[value];
        for (int j = 0; j < value-1; j++) {
            marks[j] = (int) (Math.random() * (6 - 2) + 2);
        }
        return marks;

    }


    /**
     * Отсюда запуск
     * @param args входной параметр
     */

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("Сколько студентов будет ");
        int n = in.nextInt();
        System.out.print("Введите количество оценок у студентов ");
        int value = in.nextInt();


        Student write[] = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите имя студента ");
            final String name = in.next();

            System.out.print("Введите группу студента ");
            final String group = in.next();

            int marks[] = mark(value+1);

            write[i] = new Student(name, group, marks);

            System.out.print("Какую оценку добавим студенту " + name + " 0 - ничего не добавлять " );
            int m = in.nextInt();
            if(m != 0) write[i].addMark(m);

            System.out.println("Среднее арифметическое "  + name +" "+ write[i].average()); //не получается вывести 2 знака после запятой
            if(write[i].has2()) System.out.println("У студента " + name + " есть двойки");
            else System.out.println("У студента " + name + " двоек нет");
        }
        Student.sortName(write, 0, write.length);

        System.out.println(Arrays.toString(write));
    }
}
