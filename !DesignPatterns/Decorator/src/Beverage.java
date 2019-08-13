public abstract class Beverage {

    public enum Size {TALL, GRANDE, VENTI};

    String description = "Unknown Beverage";
    Size size = Size.GRANDE;

    public String getDescription() {
        return description;
    }

    public abstract double cost();

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}


