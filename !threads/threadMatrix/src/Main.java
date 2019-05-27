public class Main {
    int sum = 0;

    private void ch() { sum ++; }

    private void t() {
        ch();
        new Thread(() -> {ch(); for (int i = 1; i <= 10; i++) sum += i; }).start();
    }

    public static void main(String[] args) {

        Matrix.generateRandomValue();
  //      Matrix.viewMatrix(Matrix.getMatrix1());
  //      Matrix.viewMatrix(Matrix.getMatrix2());
        long time = System.currentTimeMillis();
        Matrix.createMatrix(Matrix.getMatrix1(), Matrix.getMatrix2());
        time = System.currentTimeMillis() - time;
        System.out.println(time);
   //     Matrix.viewMatrix(Matrix.getMatrix3());
        time = System.currentTimeMillis();
        ThreadsMatrix.makeMatrix4();
        ThreadsMatrix.waitThreads();
        time = System.currentTimeMillis() - time;
        System.out.println(time);
        Matrix.viewMatrix(Matrix.getMatrix4());
    }
}
