
import java.util.Observable;

public class WeatherDate extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() { // оповещение наблюдателей об изменении состояния через библиотечный метод
        setChanged();
        notifyObservers(); // объект данных не передается, используем модель запроса
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
