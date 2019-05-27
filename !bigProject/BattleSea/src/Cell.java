public class Cell {
    private Width width;
    private Height height;
    private Boolean beat = false;
    private State state = State.EMPTY;
    private Boat boat;


    public Cell(Width width, Height height) {
        this.width = width;
        this.height = height;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public String toString() {
        return width.toString() + height.toString();
    }

    public Width getWidth() {
        return width;
    }

    public void setWidth(Width width) {
        this.width = width;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Boolean getBeat() {
        return beat;
    }

    public void setBeat(Boolean beat) {
        this.beat = beat;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
