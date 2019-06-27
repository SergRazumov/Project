import java.util.ArrayList;

public class WeatherDate implements Subject{
    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherDate() {
        observers = new ArrayList<>();
    }

    public void registerObserver(Observer o) { //регистрация наблюдателя
        observers.add(o);
    }

    public void removeObserver(Observer o) { //удаление наблюдателя из списка
        int i = observers.indexOf(o);
        if(i>=0) {
            observers.remove(i);
        }
    }
    public void notifyObserver() { // оповещение наблюдателей об изменении состояния через метод update()
        for(int i =0; i< observers.size(); i++) {
            Observer observer = observers.get(i);
            observer.update(temperature, humidity, pressure);
        }
    }
        public void measurementsChanged() {
        notifyObserver();
    }

        public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
