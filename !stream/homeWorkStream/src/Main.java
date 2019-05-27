import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Stream.readFile("Student.txt", list);
        Stream.viewList(list);
    }
}
