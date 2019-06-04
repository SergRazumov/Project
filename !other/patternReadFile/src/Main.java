import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        readFile("!other/patternReadFile/src/Student.txt", list);
        System.out.print(list.get(0).getString());
    }

    private static void readFile(String nameFile, List<Student> list) {
        try {
            Scanner scanner = new Scanner(new File(nameFile));
           /* Pattern name = Pattern.compile("");
            Pattern group = Pattern.compile("");
            Pattern marks = Pattern.compile("");
            */
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                Student student = new Student();
                Pattern stud = Pattern.compile("([а-яА-Я]+\\s[а-яА-Я]+\\s[а-яА-Я]+)\\W+([0-9]{3})\\W+(([2-5]\\s*)+)");
                Matcher m = stud.matcher(line);
                int index =0;
                while (m.find(index)) {
            //       System.out.print("Found: [" + m.group(1) + "] [" + m.group(2) + "] [" + m.group(3) + "]");
                    student.setNames(m.group(1));
                    student.setGroup(Integer.valueOf(m.group(2)));
                    student.setMarks(m.group(3));
                    index = m.end();
                }
                list.add(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
