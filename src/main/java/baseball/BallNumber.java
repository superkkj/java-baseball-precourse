package baseball;

import java.util.Objects;


public class BallNumber {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private int ballNumber;

    public BallNumber(int ballNumber) {
        checkMaxNumber(ballNumber);
        checkMinNumber(ballNumber);
        this.ballNumber = ballNumber;
    }


    public static BallNumber of(int ballNumber) {
        return new BallNumber(ballNumber);
    }

    private void checkMaxNumber(int ballNumber) {
        if (ballNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("숫자 9를 초과 하면 안됍니다.");
        }
    }

    private void checkMinNumber(int ballNumber) {
        if (ballNumber < MIN_NUMBER) {
            throw new IllegalArgumentException("숫자 1보다 미만이면 안됍니다.");
        }
    }

    public Boolean matchBallNumber(int ballNumber) {
        return this.ballNumber == ballNumber;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
