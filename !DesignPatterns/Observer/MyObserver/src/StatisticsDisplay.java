import java.util.Arrays;

public class StatisticsDisplay implements Observer, DisplayElement {

    private Subject weatherDate;
    private float[] temper = new float[3];

    public StatisticsDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        for (int i = 0; i < 2; i++) {
            if (temper[i] == 0) {
                temper[i] = temp;
                display();
                return;
            }
        }
        if(temper[2] == 0) {
            temper[2] = temp;
        }
        Arrays.sort(temper);
        if (temp <= temper[0]) {
            temper[0] = temp;
        } else if (temp >= temper[2]) {
            temper[2] = temp;
        } else {
            temper[1] = temp;
        }
        display();
    }

    @Override
    public void display() {
        if (temper[1] == 0) {
            System.out.println("medium temperature " + temper[0] + "\n");
        } else if (temper[2] == 0) {
            if (temper[0] < temper[1]) {
                System.out.println("Min temperature: " + temper[0] + " Max temperature" + temper[1]);
            } else {
                System.out.println("Min temperature: " + temper[1] + " Max temperature" + temper[0] + "\n");
            }
        } else {
            System.out.println("Min temperature: " + temper[0] + " Medium temperature " + temper[1] + " Max temperature " + temper[2] + "\n");
        }
    }
}
