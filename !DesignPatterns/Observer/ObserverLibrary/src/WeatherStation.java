public class WeatherStation {
    public static void main(String[] args) {
        WeatherDate weatherDate = new WeatherDate();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherDate);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherDate);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherDate);
        weatherDate.setMeasurements(85, 65, 30.4f);
        weatherDate.setMeasurements(82, 70, 29.2f);
        weatherDate.setMeasurements(78, 90, 29.2f);
        weatherDate.setMeasurements(10, 90, 29.2f);
    }
}
