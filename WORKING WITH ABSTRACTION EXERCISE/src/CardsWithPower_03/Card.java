package CardsWithPower_03;

public class Card {
    private RankPower rank;
    private SuitPower suit;

    public Card(RankPower rank, SuitPower suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public RankPower getRank() {
        return rank;
    }

    public SuitPower getSuit() {
        return suit;
    }

    public int totalPower() {
        return rank.getValue() + suit.getIndex();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d",this.rank.name(),this.suit.name(),this.totalPower());
    }
}
