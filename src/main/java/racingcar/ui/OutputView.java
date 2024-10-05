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
