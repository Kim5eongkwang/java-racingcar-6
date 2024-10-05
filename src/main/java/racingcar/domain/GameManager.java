package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;

public class GameManager {
    private final CarManager carManager;
    private final InputView inputView;
    private final OutputView outputView;
    private final Judgement judgement;

    public GameManager() {
        carManager = new CarManager();
        outputView = new OutputView();
        inputView = new InputView(outputView);
        judgement = new Judgement(carManager);
    }

    public void gameStart() {
        List<String> carNames = inputView.readCarName();

        addCars(carNames);

        outputView.printResultMessage();
        int moveCount = inputView.readMoveCount();
        moveCars(moveCount, carManager.getCarList());

        outputView.printWinner(judgement.getWinnerList());
    }

    private void moveCars(int moveCount, List<Car> cars) {
        for(int i = 0; i < moveCount; i++) {
            carManager.timePass(() -> Randoms.pickNumberInRange(0,9));
            outputView.printResult(cars);
        }
    }

    private void addCars(List<String> carNames) {
        for(String carName : carNames) {
            carManager.addCar(new RacingCar(carName));
        }
    }


}
