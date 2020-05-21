package flightSim;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}