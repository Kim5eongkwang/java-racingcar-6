package racingcar;

public class RacingCar implements Car {

    private String carName;
    private int carPosition;

    public RacingCar(String name) {
        this();
        setCarName(name);
    }

    public RacingCar() {
        carPosition = 0;
    }

    @Override
    public void setCarName(String name) {
        carName = name;
    }

    @Override
    public void increaseCarDistance() {
        carPosition++;
    }

    @Override
    public int getCarPosition() {
        return carPosition;
    }

    @Override
    public String getCarName() {
        return carName;
    }

}
