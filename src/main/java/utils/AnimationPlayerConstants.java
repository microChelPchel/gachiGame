package utils;

public enum AnimationPlayerConstants {
    IDLE(0),
    RUN(1);

    private final int value;
    private AnimationPlayerConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
