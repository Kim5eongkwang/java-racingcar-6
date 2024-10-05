package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class JudgementTest {

    @Test
    void 한_자동차가_우승() {

        //given
        Car car1 = new RacingCar("병훈");
        car1.increaseCarDistance();

        Car car2 = new RacingCar("재훈");

        CarManager carManager = new CarManager();
        carManager.addCar(car1);
        carManager.addCar(car2);

        Judgement judgement = new Judgement(carManager);

        //when

        List<Car> winner = judgement.getWinnerList();

        //then

        assertThat(winner.size()).isEqualTo(1);
        assertThat(winner.get(0)).isEqualTo(car1);
    }

    @Test
    void 다수의_자동차가_우승() {

        //given
        Car car1 = new RacingCar("병훈");
        car1.increaseCarDistance();

        Car car2 = new RacingCar("재훈");
        car2.increaseCarDistance();

        Car car3 = new RacingCar("성광");

        CarManager carManager = new CarManager();
        carManager.addCar(car1);
        carManager.addCar(car2);
        carManager.addCar(car3);

        Judgement judgement = new Judgement(carManager);

        //when

        List<Car> winner = judgement.getWinnerList();

        //then

        assertThat(winner.size()).isEqualTo(2);
        assertThat(winner.get(0)).isEqualTo(car1);
        assertThat(winner.get(1)).isEqualTo(car2);
    }

}