package racingcar.global.util;

import java.util.List;
import racingcar.global.constant.Config;

public class Validator {
    public static void validateCarName(List<String> readName) {
        validateNameLength(readName);
    }

    private static void validateNameLength(List<String> readName) {
        for (String name : readName) {
            if (name.length() > Config.MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름이 " + Config.MAX_NAME_LENGTH + "자가 넘어갑니다.");
            }
        }
    }

    public static void validateMoveCount(String readCount) {
        try {
            Integer.parseInt(readCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("이동할 숫자가 올바르지 않습니다.");
        }

    }
}
