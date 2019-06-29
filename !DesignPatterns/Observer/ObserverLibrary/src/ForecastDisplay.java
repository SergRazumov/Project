import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;

    public ForecastDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherDate) {
            WeatherDate weatherDate = (WeatherDate) o;
            temperature = weatherDate.getTemperature();
            display();
        }
    }

    @Override
    public void display() {
        System.out.println("Current temperature: " + temperature);
    }

}


