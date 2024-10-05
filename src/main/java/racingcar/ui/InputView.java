package racingcar.ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.global.constant.Config;
import racingcar.global.util.Validator;

public class InputView {
    private final OutputView outputView;

    public InputView(OutputView outputView) {
        this.outputView = outputView;
    }

    public List<String> readCarName() {
        outputView.printInputMessage();
        return readName();
    }

    public int readMoveCount() {
        outputView.printInputCountMessage();
        return readCount();
    }

    private List<String> readName() {
        String input = readLine();
        List<String> readName = List.of(input.split(Config.SEPARATOR));

        Validator.validateCarName(readName);

        return readName;
    }

    private int readCount() {
        String readCount = readLine();

        Validator.validateMoveCount(readCount);

        return Integer.parseInt(readCount);
    }

}
