package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomBaseBallGenerator implements BallNumberGenerator {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 0;
    private static final int BALLS_SIZE = 3;

    private List<Integer> ballNumbers = new ArrayList<>();

    @Override
    public List<Integer> generate() {
        while (ballNumbers.size() < BALLS_SIZE) {
            ballNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
            removeDuflicate();
        }

        return ballNumbers;
    }

    private void removeDuflicate() {
        ballNumbers = ballNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
