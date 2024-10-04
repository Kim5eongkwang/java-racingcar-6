package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void 자동차_위치_반환() {

        // given

        RacingCar initRacingCar = new RacingCar();
        RacingCar racingCar = new RacingCar();

        // when

        // then

        assertThat(racingCar.getCarPosition()).isEqualTo(initRacingCar.getCarPosition());
    }

    @Test
    void 자동차_이름_부여() {

        // given

        RacingCar racingCar = new RacingCar("test");
        String nameTest = "test";

        // when

        // then

        assertThat(racingCar.getCarName()).isEqualTo(nameTest);
    }


}
