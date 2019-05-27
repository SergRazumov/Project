import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {
    private static void printWay(List<Point> way) {
        for (Point p : way) {
            System.out.print("(" + p.x + "," + p.y + ") ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<ArrayList<Integer>> matrix = new LinkedList<>();
        readFile(matrix);
        viewMassive(matrix);
        //List<Point> way = findPath(matrix);
        List<Point> way = findWay(matrix, 0, 0);
        if (way != null) {
            System.out.println("Путь найден");
            printWay(way);
        } else {
            System.out.println("Путь не найден ");
        }
    }

    private static void viewMassive(List<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> cells : matrix) {
            System.out.println();
            for (Integer cell : cells) {
                System.out.print(cell + "\t ");
            }
        }
        System.out.println();
    }


    private static void readFile(List<ArrayList<Integer>> matrix) {
        try (Scanner scan = new Scanner(new File("Matrix1.txt"))) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                String[] letters = line.split(" ");
                ArrayList<Integer> cells = new ArrayList<>();
                for (String letter : letters) {
                    if (letter.equals("")) continue;
                    cells.add(Integer.valueOf(letter));
                }
                matrix.add(cells);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static List<Point> findPath(List<ArrayList<Integer>> matrix) {
        int maxI= matrix.size(), maxJ = matrix.get(0).size();
        Dir[][] dir = new Dir[maxI][maxJ];
        dir[maxI-1][maxJ-1] = Dir.DOWN;
        for (int j = maxJ-2; j >= 0; j--) {
           if (dir[maxI-1][j+1] != Dir.NOWHERE && matrix.get(maxI-1).get(j) >= matrix.get(maxI-1).get(j+1)) {
               dir[maxI-1][j] = Dir.RIGHT;
           } else {
               dir[maxI-1][j] = Dir.NOWHERE;
           }
        }
        for (int i = maxI-2; i >= 0; i--) {
            if (dir[i+1][maxJ-1] != Dir.NOWHERE && matrix.get(i).get(maxJ-1) >= matrix.get(i+1).get(maxJ-1)) {
                dir[i][maxJ-1] = Dir.DOWN;
            } else {
                dir[i][maxJ-1] = Dir.NOWHERE;
            }
            for (int j = maxJ-2; j >= 0; j--) {
                if (dir[i][j+1] != Dir.NOWHERE && matrix.get(i).get(j) >= matrix.get(i).get(j+1)) {
                    dir[i][j] = Dir.RIGHT;
                } else if (dir[i+1][j] != Dir.NOWHERE && matrix.get(i).get(j) >= matrix.get(i+1).get(j)) {
                    dir[i][j] = Dir.DOWN;
                } else {
                    dir[i][j] = Dir.NOWHERE;
                }
            }
        }
        if (dir[0][0] == Dir.NOWHERE) return null;
        List<Point> path = new ArrayList<>();
        path.add(new Point(0,0));
        int i = 0, j = 0;
        while (i < maxI-1 || j < maxJ-1) {
            if (dir[i][j] == Dir.RIGHT) {
                path.add(new Point(i, ++j));
            } else {
                path.add(new Point(++i, j));
            }
        }
        return path;
    }

    private static List<Point> findWay(List<ArrayList<Integer>> matrix, int i, int j) {

        if (i == matrix.size()-1 && j == matrix.get(0).size()-1) {
            List<Point> point = new ArrayList<>();
            point.add(new Point(i, j));
            return point;
        }
        if (j < matrix.get(0).size() - 1 && matrix.get(i).get(j+1) <= matrix.get(i).get(j)) {
            List<Point> path = findWay(matrix, i, j + 1);
            if (path != null) {
                path.add(0, new Point(i, j));
                return path;
            }
        }
        if (i < matrix.size() - 1 && matrix.get(i+1).get(j) <= matrix.get(i).get(j)) {
            List<Point> path = findWay(matrix, i+ 1, j );
            if (path != null) {
                path.add(0, new Point(i, j));
                return path;
            }
        }
        return null;
    }
}
