import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Main {
    // Реализация действия суммирования элементов списка
    static class Summator implements Consumer<Integer> {
        private int sum = 0;

        @Override
        public void accept(Integer i) {
            sum += i;
        }

        public int getSum() {
            return sum;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        MyList<Integer> list = new MyList<Integer>();
        for (int i = 0; i < 5; i++) {
            list.add(2*i);
        }

        // создание анонимного класса
        // Он реализует действие (печать элемента)
        list.view(new Consumer<Integer>() {
            @Override
            public void accept(Integer i) {
                System.out.println(i);
            }
        });

        Summator summator = new Summator();
        list.view(summator);
        System.out.println(summator.getSum());

        System.out.println(list);
        list.reverse();
        System.out.println("Наоборот " + list);
        System.out.print("Введите индекс элемента который хотели бы вывести: " );
        int index = scanner.nextInt();
        try {
            System.out.println("Значение этого элемента это " + list.get(index));
            list.set(index, 23);
            System.out.println("Значение данного элемента по указанному индексу равно " + list.get(index));
            System.out.println(list);
            System.out.println("Значение удаленной ячейки это " + list.remove(index) + " под индексом элемента " + index);
            System.out.println(list);
            System.out.println("Значение первого элемента массива " + list.first());
            System.out.println("Значение последнего элемента массива " + list.last());
            System.out.println("Демонстрация записи значений в массив " + Arrays.toString(list.toArray()));
            System.out.println("Индекс элемента по его значению " + list.find(2));
            list.insert(index, 55);
                                   System.out.println("Результат после добавления элемента " + list);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка! " + e.getMessage());
        }
    }
}
