public class Dot {
    private int x,y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double Distance(Dot dot) {
       return Math.sqrt((x - dot.x)*(x - dot.x) + (y - dot.y) * (y - dot.y));
    }

}
