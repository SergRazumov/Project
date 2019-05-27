import java.util.Arrays;

/**
 * Класс студент содержащий массив оценок, имя и группу
 */
public class Student {
    private String name, group;
    private int marks[];


    Student(String name, String group, int marks[]) {
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    /**
     * Метод для расчета средней арифметической
     * @return срене-арифметическое значение
     */
    public double average() {
        double average = 0,summa = 0;
        for (int mark : marks) {
            summa += mark;
        }
        if(marks[marks.length-1] == 0) {
            average = summa / marks.length-1;
        } else {
            average = summa / marks.length;
        }
        return average;
    }

    /**
     * Добавляет оценку в массив
     * @param m оценка
     */
    public void addMark(int m) {
       marks[marks.length-1] = m;
    }

    /**
     * Проверяет есть ли двойки у данного студента
     * @return ложь или истину
     */
    public boolean has2() {
        for (int mark : marks) {
            if (mark == 2) return true;
        }
        return false;
    }

    /**
     * Печатает информацию о студенте
     * @return имя группу и массив оценок
     */
    @Override
    public String toString() {
        return "Name: " + name + "; group: " + group + "; marks: " + Arrays.toString(marks);
    }

    /**
     * Сортировка студентов по имени (узнать почему Student e = a[l]; а не Student e = a[h/2];)
     * @param a массив из студентов
     * @param l откуда соритровать
     * @param h до куда соритровать
     * @return отсортированный массив студентов
     */

    public static Student[] sortName(Student[] a ,int l, int h) {
        if(h-l<=1) return a;
        Student e = a[l];
        int i = l;
        int j = h;
        while(j>i) {
            while (j>i && a[--j].name.compareTo(e.name)>0); a[i] = a[j];
            while (j>i && a[++i].name.compareTo(e.name)<=0); a[j] = a[i];
        } a[i] = e;

        sortName(a,l,i);

        sortName(a,i+1,h);

        return a;
    }
}
