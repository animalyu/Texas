package main.java.cy.poker.deck;

/**
 * Created by anima on 2017/3/24.
 */
public class Card {
    //public enum Suit { Diamond, Heart, Spade, Club, Joker; };

    public final Suit suit;
    public final int rank;

    /*
    Construct the suit and rank of the card.
     */
    public Card(Suit newSuit, int newRank) {
        suit = newSuit;
        rank = newRank;
    }

    @Override
    public String toString() {
        if(suit != Suit.JOKER)
            return "The " + rank + " of " + suit + "s.";
        else if(rank == 0)
            return "The black Joker.";
        return "The red Joker.";
    }

    public final Boolean sameSuit(Card anotherCard) {
        if(anotherCard.suit == this.suit)
            return true;
        else
            return false;
    }

    public final Boolean sameRank(Card anotherCard) {
        if(anotherCard.rank == this.rank)
            return true;
        else
            return false;
    }

    public final Boolean isSame(Card anotherCard) {
        if(this.sameSuit(anotherCard) && this.sameRank(anotherCard))
            return true;
        else
            return false;
    }

    public final int getRank() {
        return rank;
    }
}
