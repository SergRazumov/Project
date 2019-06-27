public class ForecastDisplay implements Observer, DisplayElement{

    private float temperature;
    private Subject weatherDate;

    public ForecastDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        temperature = temp;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current temperature: " + temperature);
    }
}
