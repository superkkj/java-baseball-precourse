package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Balls {
    private final List<Ball> computerBalls = new ArrayList<>();
    private BallNumberGenerator ballNumberGenerator;
    private static final int PLAYER_BALL_SIZE = 3;
    public static final String REGEX = "[0-9]+";

    public Balls(BallNumberGenerator ballNumberGenerator) {
        this.ballNumberGenerator = ballNumberGenerator;
        initComputerBalls();
    }

    private void initComputerBalls() {
        for (int BallNumber : ballNumberGenerator.generate()) {
            computerBalls.add(Ball.of(BallNumber, ballNumberGenerator.generate().indexOf(BallNumber)));
        }
    }

    public static List<Ball> playerBallInit(String playerBallNumber) {

        validBallNumberString(playerBallNumber);
        validBallNumberSize(playerBallNumber);

        return IntStream.range(0, 3)
                .mapToObj(index -> Ball.of(playerBallNumber.charAt(index) - '0', index))
                .collect(Collectors.toList());
    }


    public static Balls of(BallNumberGenerator ballNumberGenerator) {
        return new Balls(ballNumberGenerator);
    }

    public Status playBall(Ball playerBall) {
        return computerBalls.stream()
                .map(ball -> ball.compareBall(playerBall))
                .filter(status -> status != Status.NOTHING)
                .findFirst()
                .orElse(Status.NOTHING);
    }

    public PlayResult playBalls(List<Ball> playerBalls) {
        PlayResult playResult = PlayResult.of();

        for (Ball playerBall : playerBalls) {
            playResult.reulstCount(playBall(playerBall));
        }

        return playResult;
    }

    private static void validBallNumberSize(String playerBallNumber) {
        if (playerBallNumber.length() != PLAYER_BALL_SIZE) {
            throw new IllegalArgumentException("입력하신숫자는 3자리여야 됩니다.");
        }
    }

    private static void validBallNumberString(String playerBallNumber) {
        if (!playerBallNumber.matches(REGEX)) {
            throw new IllegalArgumentException("숫자만 입력하세요");
        }
    }
}
