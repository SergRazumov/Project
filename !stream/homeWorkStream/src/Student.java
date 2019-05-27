import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    private List<String> names = new ArrayList<>();
    private int group;
    private List<Integer> marks = new ArrayList<>();


    public void setNames(String names) {
        Pattern name = Pattern.compile("([a-яА-Я]+\\W)");
        Matcher m = name.matcher(names);
        int index =0;
        while(m.find(index)) {
            this.names.add(m.group(1));
            index = m.end();
        }
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setMarks(String mark) {
        writeMarksList(mark);
    }

    public String getString() {
        StringBuilder line = new StringBuilder();

        for (String name: names) {
            line.append(name).append(" ");
        }

        line.append(group).append(" ");


        for (Integer mark: marks) {
            line.append(mark).append(" ");
        }

        return line.toString();
    }

    private void writeMarksList(String mark) {
        Pattern marks = Pattern.compile("[2-5]");
        Matcher line = marks.matcher(mark);
        int index = 0;
        while(line.find(index)) {
            this.marks.add(Integer.valueOf(line.group(0)));
            index = line.end();
        }
    }
}
