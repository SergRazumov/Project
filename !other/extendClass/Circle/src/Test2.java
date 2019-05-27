/*
Создайте подкласс Circle производный от класса TwoDShape. В нем должен быть определен метод area(),
вычисляющий площадь круга, а так же конструктор с ключевым словом super для инициализации членов,
унаследованных от класса TwoDShape.


*/
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите радиус круга: ");
        int radius = in.nextInt();
        TwoDShape a = new Circle(radius);
        a.inflate(2);

        System.out.println("Площадь круга равна " + a.area());

    }
}
