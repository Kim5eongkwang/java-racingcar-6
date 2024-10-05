package racingcar.ui;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

class OutputViewTest {
    private final PrintStream originalSystemOut = System.out; // 원래의 System.out 백업
    private ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalSystemOut);
    }

    @Test
    void 각_차수별_실행_결과_출력() {
        //given
        OutputView outputView = new OutputView();

        Car car1 = new RacingCar("a");
        car1.increaseCarDistance();
        Car car2 = new RacingCar("b");
        car2.increaseCarDistance();
        car2.increaseCarDistance();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        //when
        outputView.printResult(cars);
        cars.get(0).increaseCarDistance();
        cars.get(1).increaseCarDistance();
        outputView.printResult(cars);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("a : -\nb : --\n\na : --\nb : ---");
    }

    @Test
    void 단독_우승자_안내_문구() {
        //given
        OutputView outputView = new OutputView();
        Car car = new RacingCar("a");
        List<Car> cars = new ArrayList<>();
        cars.add(car);

        //when
        outputView.printWinner(cars);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : a");
    }

    @Test
    void 공동_우승자_안내_문구() {
        //given
        OutputView outputView = new OutputView();
        Car car1 = new RacingCar("a");
        Car car2 = new RacingCar("b");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);

        //when
        outputView.printWinner(cars);

        //then
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("최종 우승자 : a, b");

    }

}