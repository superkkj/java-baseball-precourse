package baseball;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomBaseBallGeneratorTest {

    private static LinkedHashMap<Status, Integer> statusMap = new LinkedHashMap<>();
    Map<Status, Integer> map = new TreeMap<>(statusMap);

    @Test
    void GeneratorDuplicateTest() {
        BallNumberGenerator ballNumberGenerator = new RandomBaseBallGenerator();

        assertThat(ballNumberGenerator.generate().size()).isEqualTo(ballNumberGenerator.generate().stream().distinct().count());
    }
}