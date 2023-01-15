package utils;

public class AnimationPlayerConstants {

    public static final int IDLE = 0;
    public static final int RUN = 1;
    public static final int ATTACK = 2;

    private final int value;

    private AnimationPlayerConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static int GetSpriteAmount(int player_action) {
        switch (player_action) {
            case RUN:
                return 8;
            case IDLE:
            case ATTACK:
                return 4;
            default:
                return 1;
        }

    }

}
