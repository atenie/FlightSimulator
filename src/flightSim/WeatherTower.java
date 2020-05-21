package flightSim;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        super.conditionsChanged();
    }

    @Override
    public void register(Flyable f) {
        SimulatorLogger.put(String.format("%s: registered to weather tower.\n", f));
        super.register(f);
    }

    @Override
    public void unregister(Flyable f) {
        SimulatorLogger.put(String.format("%s: unregistered from weather tower.\n", f));
        super.unregister(f);
    }
}