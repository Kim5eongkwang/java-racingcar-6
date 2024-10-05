package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void timePass(NumberGenerator generator) {
        for (Car car : cars) {
            moveCar(car, generator.getNumber());
        }
    }

    private void moveCar(Car car, int number) {
        if (number >= Config.ADVANCE_THRESHOLD) {
            car.increaseCarDistance();
        }
    }

    public List<Car> getCarList() {
        return cars;
    }


}
