import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

/**
 * Created by Home on 04.01.2019.
 */
public class Main{
    static int[][] matrix = {
            {3},
            {7, 8},
            {2, 1, 3},
            {5, 2, 0, 1}
    };
    static int[][] paths = {
            {11},
            {8, 9},
            {4, 1, 3},
            {5, 2, 0, 1}
    };


    private static int FindMinMatrix(List<List<Integer>> matrix) {
         int down;
            for (int i = matrix.size() - 2; i >= 0; i--) {
                List<Integer> list = matrix.get(i);
                for (int j = matrix.get(i).size() - 1; j >= 0; j--) {
                    if (matrix.get(i + 1).get(j) < matrix.get(i + 1).get(j + 1)) down = matrix.get(i + 1).get(j);
                    else down = matrix.get(i + 1).get(j + 1);
                    list.add(j, down += matrix.get(i).get(j));
                    list.remove(j+1);
                   }
        }
        return matrix.get(0).get(0);
    }

    private static int minPath(int[][] matrix) {
        return minPath(matrix, 0, 0);
    }

    private static int minPath(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1) return matrix[i][j];
        return matrix[i][j] + Math.min(minPath(matrix, i + 1, j), minPath(matrix, i + 1, j + 1));
    }


    private static <P> List<List<P>> readFile() {
        List<List<P>> list= new ArrayList<>();
        try {
            Scanner scan = new Scanner(new File("Piramid.txt"));
            while(scan.hasNext()) {
                        String line = scan.nextLine();
                        String str[] = line.split(" ");
                        List<P> lists= new ArrayList<>();
                        for (String num : str) {
                            if (num.equals("") || num.equals("\t")) continue;
                            lists.add(Integer.valueOf(num));
                        }
                        list.add(lists);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }



    private static void check(List<List<Integer>> list)  {
        for(List<Integer> lists: list) {
            System.out.println();
            for(Integer n : lists) {
                System.out.print(n + " ");
            }
        }
    }
    private static void chechClassicMassive(Cell[][] cells) {
        for(int i = 0; i<cells.length; i++) {
            System.out.println();
            for(int j =0; j<cells[i].length; j++) {
                System.out.print(cells[i][j].getValue() + " ");
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = readFile();
     //   check(list);
     //   System.out.println();
    //    System.out.println(minPath(matrix));
   //     System.out.println(minIndex(matrix));
        System.out.println(FindMinMatrix(list));
    //    check(list);
   //     list = readFile();
   //     System.out.println();
        Cell[][] cells = createMassive(list);
        chechClassicMassive(cells);
        Point[] point = path(cells);
        System.out.println();
        printWay(point);
    }

    private static List<Integer> minIndex(int[][] matrix) {
        return minIndex(matrix, 0, 0);
    }

    private static List<Integer> minIndex(int[][] matrix, int i, int j) {
        List<Integer> list = new ArrayList<>();
        if (i == matrix.length - 1) {
            list.add(j);
            return list;
        }
        if (minPath(matrix, i + 1, j) > minPath(matrix, i + 1, j + 1)) {
            list = minIndex(matrix, i + 1, j + 1);
        } else {
            list = minIndex(matrix, i + 1, j);
        }
        list.add(j);
        return list;
    }

    private static List<List<Cell>>  createMassive(List<List<Integer>> list) {
        List<List<Cell>> cells = new ArrayList<List<Cell>>();
        int i = -1;
        for(List<Integer> lists: list) {
            i++;
            int j =0;
            cells.add(new ArrayList<Cell>());
            for (Integer num :lists) {
                if(i == list.size() -1) { cells.get(i).add(new Cell(Status.RIGHT, num)); }
                else {
                    cells.get(i).add(new Cell(Status.NOPATH, num));
                }
                j++;
            }
        }
        return cells;
    }

    private static Point[] path(Cell[][] cells) {
        Point[] path = new Point[cells.length];
        for(int i = cells.length-2; i>=0; i--) {
            for (int j = 0; j < cells[i].length; j++) {
                if(cells[i+1][j].getValue() < cells[i+1][j+1].getValue()) {cells[i][j].setValue(cells[i+1][j].getValue() + cells[i][j].getValue()); cells[i][j].setStatus(Status.LEFT);}
                else {cells[i][j].setValue(cells[i+1][j+1].getValue() + cells[i][j].getValue()); cells[i][j].setStatus(Status.RIGHT);}
            }
        }
        int i = 0, j = 0;
        path[i] = new Point(i,j);
        while (i < cells.length - 1 && j < cells[i].length) {

            if (cells[i][j].getStatus() == Status.RIGHT) {
                path[++i] = new Point(i,++j);
            } else {
                path[++i] = new Point(i, j);
            }
        }
        return path;
    }

    private static void printWay(Point[] way) {
        for (Point p : way) {
            System.out.print("(" + p.x + "," + p.y + ") ");
        }
        System.out.println();
    }
}
