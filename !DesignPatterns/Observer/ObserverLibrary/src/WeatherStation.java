public class WeatherStation {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherDate);
        weatherDate.setMeasurements(85, 65, 30.4f);
    }
}
