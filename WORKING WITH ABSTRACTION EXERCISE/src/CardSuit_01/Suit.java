package CardSuit_01;

public enum Suit {
    CLUBS(0), DIAMONDS(1), HEARTS(2), SPADES(3);

    private final int index;

    Suit(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", this.index,this.name());
    }


}
