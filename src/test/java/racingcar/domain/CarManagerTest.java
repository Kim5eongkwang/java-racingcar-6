package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    @Test
    void 한대의_자동차_전진() {

        // given
        CarManager carManager = new CarManager();
        carManager.addCar(new RacingCar("병훈"));

        NumberGenerator numberGenerator = () -> Config.ADVANCE_THRESHOLD;

        // when
        carManager.timePass(numberGenerator);

        List<Car> carList = carManager.getCarList();
        Car car = carList.get(0);

        // then
        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getCarPosition()).isEqualTo(1);

    }

    @Test
    void 다수의_자동차_전진() {

        // given
        CarManager carManager = new CarManager();
        carManager.addCar(new RacingCar("병훈"));
        carManager.addCar(new RacingCar("재훈"));
        NumberGenerator numberGenerator = () -> Config.ADVANCE_THRESHOLD;

        // when
        carManager.timePass(numberGenerator);
        List<Car> carList = carManager.getCarList();

        Car car1 = carList.get(0);
        Car car2 = carList.get(1);

        // then
        assertThat(carList.size()).isEqualTo(2);
        assertThat(car1.getCarPosition()).isEqualTo(1);
        assertThat(car2.getCarPosition()).isEqualTo(1);

    }

    @Test
    void 한대의_자동차_멈춤() {

        // given
        CarManager carManager = new CarManager();
        carManager.addCar(new RacingCar("병훈"));

        NumberGenerator numberGenerator = () -> Config.ADVANCE_THRESHOLD - 1;

        // when
        carManager.timePass(numberGenerator);

        List<Car> carList = carManager.getCarList();
        Car car = carList.get(0);

        // then
        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getCarPosition()).isEqualTo(0);

    }

    @Test
    void 다수의_자동차_멈춤() {

        // given
        CarManager carManager = new CarManager();
        carManager.addCar(new RacingCar("병훈"));
        carManager.addCar(new RacingCar("재훈"));

        NumberGenerator numberGenerator = () -> Config.ADVANCE_THRESHOLD - 1;

        // when
        carManager.timePass(numberGenerator);

        List<Car> carList = carManager.getCarList();

        Car car1 = carList.get(0);
        Car car2 = carList.get(1);

        // then
        assertThat(carList.size()).isEqualTo(2);
        assertThat(car1.getCarPosition()).isEqualTo(0);
        assertThat(car2.getCarPosition()).isEqualTo(0);
    }

}