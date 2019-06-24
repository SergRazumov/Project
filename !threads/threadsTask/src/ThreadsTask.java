import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadsTask {

    public static void main(String[] args) {
        ThreadQueue<Thread> task = new ThreadQueue<>();


        Thread read = new Thread(task::readList);
        task.parallelStream().forEach(Runnable::run);

    }
}
