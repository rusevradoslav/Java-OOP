package CardsWithPower_03;

public enum  SuitPower {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);

    private final int index;

    SuitPower(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}
