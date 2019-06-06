public class InfoAboutCity {

    private Color color;
    private int distance;
    private int cityFrom;
    private int index;

    public InfoAboutCity(Color color, int distance, int index) {
        this.color = color;
        this.distance = distance;
        this.index = index;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getCityFrom() {
        return cityFrom;
    }

    public void setCityFrom(int cityFrom) {
        this.cityFrom = cityFrom;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
