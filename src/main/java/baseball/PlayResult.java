package baseball;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayResult {

    private static LinkedHashMap<Status, Integer> statusMap = new LinkedHashMap<>();
    private static final int ADD_STATUS_COUNT = 1;
    private static final int NOTHING_COUNT = 3;
    private static final int DEFAULT_VALUE = 0;

    public PlayResult() {
        statusMap.clear();
    }

    public static PlayResult of() {
        return new PlayResult();
    }

    public void reulstCount(Status ballStatus) {
        if (!statusMap.containsKey(ballStatus)) {
            statusMap.put(ballStatus, ADD_STATUS_COUNT);
            return;
        }
        statusMap.put(ballStatus, statusMap.get(ballStatus) + ADD_STATUS_COUNT);
    }

    public int strikeCount() {
        return statusMap.getOrDefault(Status.STRIKE, DEFAULT_VALUE);
    }

    public int ballCount() {
        return statusMap.getOrDefault(Status.BALL, DEFAULT_VALUE);
    }

    public Map<Status, Integer> resultGame() {
        removeNothing();
        sortStatusMap();
        return Collections.unmodifiableMap(statusMap);
    }

    private void removeNothing() {
        if (statusMap.get(Status.NOTHING) != null && statusMap.get(Status.NOTHING) != NOTHING_COUNT) {
            statusMap.remove(Status.NOTHING);
        }
    }

    private void sortStatusMap() {
        List<Map.Entry<Status, Integer>> collect = statusMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        listToMap(collect);
    }

    private void listToMap(List<Map.Entry<Status, Integer>> collect) {
        statusMap.clear();
        collect.forEach(s -> statusMap.put(s.getKey(), s.getValue()));
    }
}


