public class MyException extends RuntimeException {
    public MyException() {
        super("Что-то произошло");
    }

    public MyException(String s) {
        super(s);
    }
}
