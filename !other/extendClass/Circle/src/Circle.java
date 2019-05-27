public class Circle extends TwoDShape {
    private double radius;

    public Circle(int radius) {
        super("Треугольник", 2*radius, 2*radius);
        this.radius = radius;
    }

    public void inflate(double c) {
        super.inflate(c);
        radius = height / 2;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
