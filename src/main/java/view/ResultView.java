package view;

import baseball.PlayResult;
import baseball.Status;

import java.util.Map;

public class ResultView {
    public void printResult(PlayResult playResult) {
        for (Map.Entry<Status, Integer> entry : playResult.resultGame().entrySet()) {
            String ballCount = entry.getKey() == Status.NOTHING ? "" : entry.getValue().toString();
            System.out.print(ballCount + "" + entry.getKey().statusName + " ");
        }
    }

    public void answerContinuePlay() {
        System.out.println("3스트라이크");
        System.out.println("3개의숫자를모두맞히셨습니다!게임 끝");
        System.out.println("게임을새로시작하려면1,종료하려면2를입력하세요.");
    }

    public void endGameMessage() {
        System.out.print("게임 종료");
    }
}