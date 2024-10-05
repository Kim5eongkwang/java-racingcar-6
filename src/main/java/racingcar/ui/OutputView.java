package racingcar.ui;

import java.util.List;
import racingcar.domain.Car;
import racingcar.global.constant.Config;

public class OutputView {

    public void printInputMessage() {
        println(Config.INPUT_CAR_NAME_MESSAGE);
    }

    public void printInputCountMessage() {
        println(Config.INPUT_MOVE_COUNT_MESSAGE);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        print("\n");
    }

    public void printWinner(List<Car> cars) {
        print(Config.WINNER_MASSAGE);
        if (cars.size() == 1) {
            Car car = cars.get(0);
            print(car.getCarName());
            return;
        }
        for (int i = 0; i < cars.size() - 1; i++) {
            Car car = cars.get(i);
            print(car.getCarName() + ", ");
        }
        print(cars.get(cars.size() - 1).getCarName());
    }

    private void printCarStatus(Car car) {
        print(car.getCarName() + " : ");
        printCarDistance(car);
        print("\n");
    }

    private void printCarDistance(Car car) {
        for (int i = 0; i < car.getCarPosition(); i++) {
            print("-");
        }
    }

    private void print(String string) {
        System.out.print(string);
    }

    private void println(String string) {
        System.out.println(string);
    }
}
