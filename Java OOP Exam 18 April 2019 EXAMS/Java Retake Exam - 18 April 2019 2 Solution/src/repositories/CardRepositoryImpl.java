package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new LinkedList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return Collections.unmodifiableList(this.cards);
        //sumnitelno
    }

    @Override
    public void add(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        for (Card c : this.cards) {
            if (c.getName().equals(card.getName())) {
                throw new IllegalArgumentException(String.format("Card %s already exists!", card.getName()));
            }
        }
        this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("Card cannot be null!");
        }
        boolean isRemoved = false;
        for (Card c : cards) {
            if (c.getName().equals(card.getName())) {
                this.cards.remove(c);
                isRemoved = true;
            }
        }

        return isRemoved;
    }

    @Override
    public Card find(String name) {
        Card card = null;
        for (Card c : this.cards) {
            if (c.getName().equals(name)) {
                card = c;
            }
        }
        return card;
    }
}
