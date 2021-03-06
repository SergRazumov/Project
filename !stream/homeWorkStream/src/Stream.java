import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stream {

    public static void readFile(String file, List<Student> list) {
        try {
            Scanner scan = new Scanner(new File(file));
            while (scan.hasNext()) {
                Student student = new Student();
                String line = scan.nextLine();
                Pattern name = Pattern.compile("[а-яА-Я]+");
                Pattern group = Pattern.compile("\\d{3}");
                Pattern mark = Pattern.compile("[2-5]");
                Matcher n = name.matcher(line);
                Matcher g = group.matcher(line);
                Matcher m = mark.matcher(line);
                int index = 0;
                while(n.find(index)) {
                    student.setNames(n.group(0));
                    index = n.end();
                }
                if(g.find(index)) {
                    student.setGroup(Integer.parseInt(g.group(0)));
                    index = g.end();
                }
                while(m.find(index)) {
                    student.setMarks(m.group(0));
                    index = m.end();
                }
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void viewList(List<Student> list) {
        for(Student student:list) {
            System.out.println(student.getString());
        }
    }
}
