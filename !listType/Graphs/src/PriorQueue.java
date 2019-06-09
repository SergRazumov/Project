public class PriorQueue implements PriorityQueque<InfoAboutCity> {

    InfoAboutCity[] queue;
    int size = 0;

    public PriorQueue(int length) {
        queue = new InfoAboutCity[length];
    }

    @Override
    public void addElement(InfoAboutCity infoAboutCity) {
        queue[size] = infoAboutCity;
        infoAboutCity.setIndexQueue(size);
        changePriorityMinValue(infoAboutCity);
        size++;
    }

    @Override
    public InfoAboutCity removeMin() {
        int k = 0;
        int i;
        int j;
        InfoAboutCity returnInfoAboutCity = queue[k];
        queue[k] = queue[size - 1];
        queue[k].setIndexQueue(k);
        queue[--size] = null;
        do {
            i = 2 * k + 1;
            j = 2 * k + 2;
            if((queue[i]!=null && queue[j]!=null && queue[i].getDistance() > queue[j].getDistance()) || queue[i]==null && queue[j]!=null && queue[j].getDistance()< queue[k].getDistance()) {
                InfoAboutCity infoJ = queue[j];
                queue[j] = queue[k];
                queue[j].setIndexQueue(j);
                queue[k] = infoJ;
                queue[k].setIndexQueue(k);
                k = j;
            } else if((queue[i]!=null && queue[j]!=null && queue[i].getDistance() < queue[j].getDistance()) || queue[j]==null && queue[i]!=null && queue[i].getDistance()< queue[k].getDistance()) {
                InfoAboutCity infoI = queue[i];
                queue[i] = queue[k];
                queue[i].setIndexQueue(i);
                queue[k] = infoI;
                queue[k].setIndexQueue(k);
                k = i;
            }
            else break;
        }
        while (true);
        return returnInfoAboutCity;
    }

    @Override
    public void raisePriority(InfoAboutCity infoAboutCity) {
        size--;
        changePriorityMinValue(infoAboutCity);
        size++;
    }

    private void changePriorityMinValue(InfoAboutCity infoAboutCity) {
        int i = (size - 1) / 2;
        while (queue[i].getDistance() > infoAboutCity.getDistance()) {
            InfoAboutCity a = queue[i];
            queue[i] = infoAboutCity;
            queue[i].setIndexQueue(i);
            queue[size] = a;
            queue[size].setIndexQueue(size);
            i = (i - 1) / 2;
        }
    }

    @Override
    public boolean isEmpty() {
        return queue[0] == null;
    }
}
