package maps;

import java.util.Objects;

public class Car {
    private final String name;
    private final double power;

    public Car(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return car.power == power &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
