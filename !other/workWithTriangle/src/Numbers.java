import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static Point getPoint() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите координату X ");
        double x = in.nextDouble();
        System.out.print("Введите координату Y ");
        double y = in.nextDouble();
        return new Point(x, y);
    }

    public static void main(String args[]) {
        Point p = getPoint();
        Point[] ps = new Point[3];
        for (int i = 0; i < 3; i++) {
            ps[i] = getPoint();
        }
        Triangle n2 = new Triangle(ps);



        System.out.println(String.format("Площадь треугольника равна %.4f", n2.square()));
        System.out.println("Углы данного треугольника " + Arrays.toString(n2.angles()));
        if(n2.inside(p)) System.out.println("Точка с указанными координатами находится внутри треугольника ");
        else System.out.println("Точка с указанными координатами вне треугольника ");
    }
}
