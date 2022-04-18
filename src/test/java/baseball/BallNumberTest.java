package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class BallNumberTest {
    @Test
    void ballNumberMinFailTest() {
        assertThatThrownBy(
                () -> BallNumber.of(0)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballNumberMinPassTest() {
        BallNumber ballNumber = BallNumber.of(1);
        assertThat(ballNumber.matchBallNumber(1)).isTrue();
    }

    @Test
    void ballNumberMaxFailTest() {
        assertThatThrownBy(
                () -> BallNumber.of(10)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void ballNumberMaxPassTest() {
        BallNumber ballNumber = BallNumber.of(9);
        assertThat(ballNumber.matchBallNumber(9)).isTrue();
    }

    @Test
    void compareBallNumber() { // false도 테스트해야할듯
        BallNumber ballnumber1 = BallNumber.of(1);
        BallNumber ballnumber2 = BallNumber.of(1);

        assertThat(ballnumber1.equals(ballnumber2)).isTrue();
    }
}
