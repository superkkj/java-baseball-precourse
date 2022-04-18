package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @Test
    void ballMaxNumberTestFail() {
        assertThatThrownBy(
                () -> Ball.of(10, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballMaxNumberTestPass() {
        assertThat(Ball.of(9, 0).matchBallNumber(9)).isTrue();
    }

    @Test
    void ballMinNumberTestFail() {
        assertThatThrownBy(
                () -> Ball.of(0, 0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballMixNumberTestPass() {
        assertThat(Ball.of(1, 0).matchBallNumber(1)).isTrue();
    }


    @Test
    void strikeTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(1, 0))).isEqualTo(Status.STRIKE);
    }

    @Test
    void ballTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(1, 1))).isEqualTo(Status.BALL);
    }

    @Test
    void NothingTest() {
        Ball ball = Ball.of(1, 0);
        assertThat(ball.compareBall(Ball.of(2, 2))).isEqualTo(Status.NOTHING);
    }
}
