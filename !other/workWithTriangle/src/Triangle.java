import java.lang.Math;

public class Triangle {
    private Point p1, p2, p3;
    private double A, B, C; //почему не final? До создания типа Point позволяло.

    private void init(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        A = p1.distance(p2);
        B = Point.distance(p2, p3);
        C = Point.distance(p1, p3);
    }

    public Triangle(Point p1, Point p2, Point p3) {
        this.init(p1, p2, p3);
    }

    public Triangle(Point[] ps) {
        if (ps.length != 3) throw new IllegalArgumentException();
        init(ps[0], ps[1], ps[2]);
    }

    public double square() {
        double s, p;
        p = (A + B + C) / 2;
        s = Math.sqrt(p * (p - A) * (p - B) * (p - C));
        return s;
    }

    public double[] angles() {
        double angl[] = new double[3];
        angl[0] = Math.toDegrees(Math.acos(((this.A * this.A) + (this.C + this.C) - (this.B + this.B)) / (2 * this.A * this.C)));
        angl[1] = Math.toDegrees(Math.acos(((this.A * this.A) + (this.B + this.B) - (this.C + this.C)) / (2 * this.A * this.B)));
        angl[2] = 180 - angl[0] - angl[1];
        return angl;
    }

    public boolean inside(Point p) {
        return ((p1.getX() - p.getX()) * (p2.getY() - p1.getY()) - (p2.getX() - p1.getX()) * (p1.getY() - p.getY()) >= 0 &&
                (p2.getX() - p.getX()) * (p3.getY() - p2.getY()) - (p3.getX() - p2.getX()) * (p2.getY() - p.getY()) >= 0 &&
                (p3.getX() - p.getX()) * (p1.getY() - p3.getY()) - (p1.getX() - p3.getX()) * (p3.getY() - p.getY()) >= 0) ||
                (p1.getX() - p.getX()) * (p2.getY() - p1.getY()) - (p2.getX() - p1.getX()) * (p1.getY() - p.getY()) <= 0 &&
                (p2.getX() - p.getX()) * (p3.getY() - p2.getY()) - (p3.getX() - p2.getX()) * (p2.getY() - p.getY()) <= 0 &&
                (p3.getX() - p.getX()) * (p1.getY() - p3.getY()) - (p1.getX() - p3.getX()) * (p3.getY() - p.getY()) <= 0 ;

    }
}


