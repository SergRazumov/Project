public class PointMatrix extends Thread {
    private int i, j;

    public PointMatrix(int i, int j) {
        this.i = i;
        this.j = j;
    }


    @Override
    public void run() {
       Matrix.getMatrix4()[i][j] = Matrix.cell(j ,i);
    }
}
