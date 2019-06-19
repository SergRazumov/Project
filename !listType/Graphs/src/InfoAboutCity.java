import priorityqueue.PrioQueueElement;

public class InfoAboutCity implements PrioQueueElement {

    private Color color;
    private int distance;
    private int cityFrom;
    private int index;
    private int indexQueue;

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

    public int getIndexQueue() {
        return indexQueue;
    }

    public void setIndexQueue(int indexQueue) {
        this.indexQueue = indexQueue;
    }
}
