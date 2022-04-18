package baseball;

import view.InputView;
import view.ResultView;

import java.util.List;

import static baseball.Balls.REGEX;


public class BaseBallGame {

    private static final int STRIKE_COUNT = 3;
    private static final int COUNTINUE_GAME_NUMBER = 1;
    private Balls computerBalls;
    private Boolean gameContinue;
    private InputView inputView;
    private ResultView resultView;

    BaseBallGame() {
        this.computerBalls = Balls.of(new RandomBaseBallGenerator());
        this.gameContinue = true;
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    void playBallsBallGame() {
        while (gameContinue) {
            String playerBall = inputView.insertBallNumbers();
            playStart(playerBall);
        }
    }

    private void playStart(String playerBall) {
        try {
            countHit(Balls.playerBallInit(playerBall));
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void countHit(List<Ball> playerBallNumber) {
        PlayResult playResult = computerBalls.playBalls(playerBallNumber);
        if (playResult.strikeCount() == STRIKE_COUNT) {
            selectGamePlay();
            return;
        }
        resultView.printResult(playResult);
    }

    private void selectGamePlay() {
        resultView.answerContinuePlay();
        int playerInput = inputView.insertSelectGameContinue();
        validInputNumber(playerInput);
        validInputString(playerInput);
        if (playerInput == COUNTINUE_GAME_NUMBER) {
            computerBalls = Balls.of(new RandomBaseBallGenerator());
            playBallsBallGame();
        }
        gameEnd();
    }

    private void validInputNumber(int playerInput) {
        if (playerInput > 3) {
            throw new IllegalArgumentException("1 과 2 중 하나만 선택해서 입력해 주세요.");
        }
    }

    private void validInputString(int playerInput) {
        if (!String.valueOf(playerInput).matches(REGEX)) {
            throw new IllegalArgumentException("숫자만 입력하세요.");
        }
    }

    private void gameEnd() {
        gameContinue = false;
        resultView.endGameMessage();
    }
}




