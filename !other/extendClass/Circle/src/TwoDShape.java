public abstract class TwoDShape {
    protected final String name;
    protected double width, height;

    public TwoDShape(String name, double width, double height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void inflate(double c) {
        width *= c;
        height *= c;
    }

    abstract double area();
}
