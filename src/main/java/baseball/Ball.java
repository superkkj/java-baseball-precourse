package baseball;

import java.util.Objects;

public class Ball {

    private final BallNumber ballNumber;
    private int position;

    public Ball(int ballNumber, int position) {
        this.ballNumber = BallNumber.of(ballNumber);
        this.position = position;
    }

    public static Ball of(int ballNumber, int position) {
        return new Ball(ballNumber, position);
    }

    public Boolean matchBallNumber(int ballNumber) {
        return this.ballNumber.matchBallNumber(ballNumber);
    }

    public Status compareBall(Ball ball) {

        if (strikeCheck(ball)) {
            return Status.STRIKE;
        }

        if (ballCheck(ball)) {
            return Status.BALL;
        }

        return Status.NOTHING;
    }

    public Boolean strikeCheck(Ball ball) {
        return equals(ball);
    }

    public Boolean ballCheck(Ball ball) {
        return this.ballNumber.equals(ball.ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position &&
                Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber, position);
    }
}
