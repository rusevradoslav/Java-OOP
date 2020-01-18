package viceCity.models.players;

public class CivilPlayer extends BasePlayer {
    private static final int DEFAULT_LIFE_POINT = 50;

    public CivilPlayer(String name) {
        super(name, DEFAULT_LIFE_POINT);
    }
}
