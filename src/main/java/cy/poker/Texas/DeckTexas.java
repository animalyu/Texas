package main.java.cy.poker.Texas;

import main.java.cy.poker.deck.Card;
import main.java.cy.poker.deck.Deck;
import main.java.cy.poker.deck.Suit;

/**
 * Created by anima on 2017/3/26.
 */
public class DeckTexas extends Deck {
    public DeckTexas() {
        cardNumber = 52;
        cards = new Card[cardNumber];
        for (int rankVal = 0; rankVal < 13; rankVal++)
        {
            cards[rankVal] = new Card(Suit.CLUB, rankVal + 2);
            cards[13 + rankVal] = new Card(Suit.DIAMOND, rankVal + 2);
            cards[26 + rankVal] = new Card(Suit.SPADE, rankVal + 2);
            cards[39 + rankVal] = new Card(Suit.HEART, rankVal + 2);
        }
    }
}
