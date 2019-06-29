import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float[] temper = new float[3];


    public StatisticsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        if (temper[1] == 0) {
            System.out.println("medium temperature " + temper[0]);
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

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherDate) {
            WeatherDate weatherDate = (WeatherDate) o;
            temperature = weatherDate.getTemperature();
            for (int i = 0; i < 2; i++) {
                if (temper[i] == 0) {
                    temper[i] = temperature;
                    display();
                    return;
                }
            }
            if(temper[2] == 0) {
                temper[2] = temperature;
            }
            Arrays.sort(temper);
            if (temperature <= temper[0]) {
                temper[0] = temperature;
            } else if (temperature >= temper[2]) {
                temper[2] = temperature;
            } else {
                temper[1] = temperature;
            }
            display();
        }
    }
}
