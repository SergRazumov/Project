public class Point {
    private final double X,Y;

    Point (double x, double y) {
        this.X = x;
        this.Y = y;
    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.X-p2.X)*(p1.X-p2.X) + (p1.Y-p2.Y)*(p1.Y-p2.Y));
    }

    public double distance(Point p) {
        return distance(this, p);
    }
}

