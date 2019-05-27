import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ThreadsMatrix {

    private static List<PointMatrix> list = new ArrayList<>();

    public static void makeMatrix4() {
        for(int i = 0; i<Matrix.getMatrix4().length; i++) {
            for(int j =0; j<Matrix.getMatrix4()[i].length; j++) {
                PointMatrix p = new PointMatrix(i,j);
                list.add(p);
                p.start();
            }
        }
    }

    public static void waitThreads() {
        for(PointMatrix p:list) {
            try {
                p.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

