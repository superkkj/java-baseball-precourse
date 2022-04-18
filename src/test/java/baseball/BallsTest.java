package baseball;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallsTest {

    private Balls balls;
    private List<Integer> ballList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 3; i++) {
            ballList.add(i + 1);
        }
        balls = Balls.of(() -> ballList);
    }

    @Test
    void BallsPlayStrike() {
        Status status = balls.playBall(Ball.of(1, 0));
        assertThat(status).isEqualTo(Status.STRIKE);

    }

    @Test
    void BallsPlayBall() {
        Status status = balls.playBall(Ball.of(1, 1));
        assertThat(status).isEqualTo(Status.BALL);

    }

    @Test
    void BallsPlayNothing() {
        Status status = balls.playBall(Ball.of(4, 0));
        assertThat(status).isEqualTo(Status.NOTHING);

    }

    @Test
    void playerBallInitTest() {
        List<Ball> ballPlayer = Balls.playerBallInit("123");
        for (int i = 0; i < ballPlayer.size(); i++) {
            assertThat(ballPlayer.get(i).matchBallNumber(i + 1)).isTrue();
        }
    }

    @Test
    void computerVsPlayerPlayBallsTest() {
        List<Ball> ballPlayer = Balls.playerBallInit("123");
        assertThat(balls.playBalls(ballPlayer).strikeCount()).isEqualTo(3);
    }

}