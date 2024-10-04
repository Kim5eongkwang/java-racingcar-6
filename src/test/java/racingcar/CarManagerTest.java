package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarManagerTest {

    @BeforeEach
    void beforeEach() {
        CarManager.carClear();
    }


    @Test
    void 한대의_자동차_전진() {

        // given
        CarManager.addCar("병훈");

        // when
        CarManager.timePass(Config.ADVANCE_THRESHOLD);

        List<Car> carList = CarManager.getCarList();
        Car car = carList.get(0);

        // then
        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getCarPosition()).isEqualTo(Config.ADVANCE_THRESHOLD);

    }

    @Test
    void 다수의_자동차_전진() {

        // given
        CarManager.addCar("병훈");
        CarManager.addCar("재훈");

        // when
        CarManager.timePass(Config.ADVANCE_THRESHOLD);

        List<Car> carList = CarManager.getCarList();

        Car car1 = carList.get(0);
        Car car2 = carList.get(1);

        // then
        assertThat(carList.size()).isEqualTo(2);
        assertThat(car1.getCarPosition()).isEqualTo(Config.ADVANCE_THRESHOLD);
        assertThat(car2.getCarPosition()).isEqualTo(Config.ADVANCE_THRESHOLD);

    }

    @Test
    void 한대의_자동차_멈춤() {

        // given
        CarManager.addCar("병훈");

        // when
        CarManager.timePass(Config.ADVANCE_THRESHOLD - 1);

        List<Car> carList = CarManager.getCarList();
        Car car = carList.get(0);

        // then
        assertThat(carList.size()).isEqualTo(1);
        assertThat(car.getCarPosition()).isEqualTo(0);

    }

    @Test
    void 다수의_자동차_멈춤() {

        // given
        CarManager.addCar("병훈");
        CarManager.addCar("재훈");

        // when
        CarManager.timePass(Config.ADVANCE_THRESHOLD - 1);

        List<Car> carList = CarManager.getCarList();

        Car car1 = carList.get(0);
        Car car2 = carList.get(1);

        // then
        assertThat(carList.size()).isEqualTo(2);
        assertThat(car1.getCarPosition()).isEqualTo(0);
        assertThat(car2.getCarPosition()).isEqualTo(0);
    }

}