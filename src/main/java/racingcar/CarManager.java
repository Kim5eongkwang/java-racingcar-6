package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private static final List<Car> cars = new ArrayList<>();

    public static void addCar(String carName) {
        cars.add(new RacingCar(carName));
    }

    public static void timePass() {
        for (Car car : cars) {
            moveCar(car, Randoms.pickNumberInRange(0, 9));
        }
    }

    public static void timePass(int distance) {
        for (Car car : cars) {
            moveCar(car, distance);
        }
    }

    public static void moveCar(Car car, int distance) {
        if (distance >= Config.ADVANCE_THRESHOLD) {
            car.setCarPosition(distance + car.getCarPosition());
        }
    }

    public static List<Car> getCarList() {
        return cars;
    }

    public static void carClear() {
        cars.clear();
    }


}
