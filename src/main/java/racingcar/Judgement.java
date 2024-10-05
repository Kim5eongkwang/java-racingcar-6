package racingcar;

import static java.lang.Math.max;

import java.util.ArrayList;
import java.util.List;

public class Judgement {

    private final List<Car> cars;
    private final List<Car> winnerList;
    private final int maxDistance;

    public Judgement(CarManager carManager) {
        cars = carManager.getCarList();
        winnerList = new ArrayList<>();
        maxDistance = findMaxDistance();
    }

    private int findMaxDistance() {
        int max = 0;
        for (Car car : cars) {
            max = max(car.getCarPosition(), max);
        }
        return max;
    }

    private void addWinnerElement(Car car) {
        if (maxDistance == car.getCarPosition()) {
            winnerList.add(car);
        }
    }

    public List<Car> getWinnerList() {
        winnerList.clear();
        for (Car car : cars) {
            addWinnerElement(car);
        }
        return winnerList;
    }
}
