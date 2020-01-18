package repositories;

import models.cards.interfaces.Card;
import repositories.interfaces.CardRepository;

import java.util.ArrayList;
import java.util.List;

import static common.ConstantMessages.*;

public class CardRepositoryImpl implements CardRepository {
    private List<Card> cards;

    public CardRepositoryImpl() {
        this.cards = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.cards.size();
    }

    @Override
    public List<Card> getCards() {
        return this.cards;
    }

    @Override
    public void add(Card card) {
         if(card==null){
             throw new IllegalArgumentException(CARD_IS_NULL);
         }
         for (Card c: this.cards){
             if(c.getName().equals(card.getName())){
                 throw new IllegalArgumentException(String.format(CARD_EXIST,card.getName()));
             }
         }
         this.cards.add(card);
    }

    @Override
    public boolean remove(Card card) {
        if(card==null){
            throw new IllegalArgumentException(CARD_IS_NULL);
        }
        for (Card c: this.cards){
            if(c.getName().equals(card.getName())){
                this.cards.remove(c);
                return true;
            }
        }
        return false;
    }

    @Override
    public Card find(String name) {
        for (Card c: this.cards){
            if(c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }
}
