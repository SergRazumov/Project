import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       LinkedList <Point> list = readFile();
       double summ =0;
       if (list == null) return;
       Point last = list.getLast();
        for(Point pt : list) {
            summ += last.distance(pt);
            last = pt;
        }
        System.out.println(summ);
    }


    private static LinkedList<Point> readFile() {
        try (Scanner scan = new Scanner(new File("Coordinate.txt"))) {
            LinkedList<Point> list = new LinkedList<>();
            while (scan.hasNext()) {
                list.add(new Point(scan.nextInt(), scan.nextInt()));
            }
            return list;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Нечетное число координат");
        }
        return null;
    }
}
