package racingcar.global.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.global.constant.Config;

class ValidatorTest {

    @Test
    void 자동차이름이_최대길이를_넘을때_예외발생() {
        //given
        String name = "a".repeat(Config.MAX_NAME_LENGTH + 1);
        List<String> list = new ArrayList<>();
        list.add(name);

        //when & then
        assertThatThrownBy(() -> Validator.validateCarName(list))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름이 " + Config.MAX_NAME_LENGTH + "자가 넘어갑니다.");
    }

    @Test
    void 이동할값이_숫자가아니면_예외발생() {
        //given
        String count = "abc";

        //when & then
        assertThatThrownBy(() -> Validator.validateMoveCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이동할 숫자가 올바르지 않습니다.");
    }


}