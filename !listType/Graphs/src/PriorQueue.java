public class PriorQueue implements PriorityQueque<InfoAboutCity> {

    InfoAboutCity[] queue;
    int size = 0;

    public PriorQueue(int length) {
        queue = new InfoAboutCity[length];
    }

    @Override
    public void addElement(InfoAboutCity infoAboutCity) {
        queue[size++] = infoAboutCity;
        while(k<) {
            int k =
        }
    }

    @Override
    public InfoAboutCity removeMin() {
        return null;
    }

    @Override
    public void changePriority(InfoAboutCity infoAboutCity) {

    }

    @Override
    public boolean isEmpty() {
        return queue[0]==null;
    }
}
