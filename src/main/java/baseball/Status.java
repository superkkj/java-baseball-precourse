package baseball;

public enum Status {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    public final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

}
