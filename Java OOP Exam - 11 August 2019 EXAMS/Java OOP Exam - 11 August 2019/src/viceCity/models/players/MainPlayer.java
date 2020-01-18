package viceCity.models.players;

public class MainPlayer extends BasePlayer {
    private static final String NAME = "Tommy Vercetti";
    private static final int DEFAULT_LIFE_POINTS = 100;

    public MainPlayer() {
        super(NAME, DEFAULT_LIFE_POINTS);
    }
}
