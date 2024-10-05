package racingcar.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.close;
import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @AfterEach
    void 초기화() {
        close();
    }

    @Test
    void 여러대의_자동차_이름_입력() {
        // given
        InputView inputView = new InputView(new OutputView());
        String userInput = "a,b\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when
        List<String> list = inputView.readCarName();

        // then
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0)).isEqualTo("a");
        assertThat(list.get(1)).isEqualTo("b");
    }

    @Test
    void 한대의_자동차_이름_입력() {
        // given
        InputView inputView = new InputView(new OutputView());
        String userInput = "a\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when
        List<String> list = inputView.readCarName();

        // then
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.get(0)).isEqualTo("a");
    }

    @Test
    void 숫자_값_입력() {
        // given
        InputView inputView = new InputView(new OutputView());
        String userInput = "3";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when
        int input = inputView.readMoveCount();

        // then
        assertThat(input).isEqualTo(Integer.parseInt(userInput));
    }
}
