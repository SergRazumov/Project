import java.util.EventListener;

public class Example {

    private int value;
    private String line;
    public int randomVal = 5;
    public boolean myTrue = true;

    public Example() {

    }

    public Example(int value) {
        this.value = value;
    }

    public Example(String line) {
        this.line = line;
    }

    public Example(String line, int value) {
        this. line = line;
        this.value  = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }
}
