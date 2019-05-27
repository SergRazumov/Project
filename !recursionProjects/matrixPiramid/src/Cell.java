public class Cell {

    private Status status;
    private int value;

    public Cell(Status status, int value) {
        this.status = status;
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


}
