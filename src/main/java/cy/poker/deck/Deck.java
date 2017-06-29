package main.java.cy.poker.deck;

import java.util.Arrays;
import java.util.Random;
/**
 * Created by anima on 2017/3/25.
 */
public class Deck {
    protected Card[] cards;
    protected int cardNumber;

    public Deck() {
        cardNumber = 54;
        cards = new Card[cardNumber];
        for (int rankVal = 0; rankVal < 13; rankVal++)
        {
            cards[rankVal] = new Card(Suit.CLUB, rankVal + 2);
            cards[13 + rankVal] = new Card(Suit.DIAMOND, rankVal + 2);
            cards[26 + rankVal] = new Card(Suit.SPADE, rankVal + 2);
            cards[39 + rankVal] = new Card(Suit.HEART, rankVal + 2);
        }
        cards[cardNumber - 2] = new Card(Suit.JOKER, 0);
        cards[cardNumber - 1] = new Card(Suit.JOKER, 1);
    }

    public final Card getCard(int cardNum) throws Exception {
            if (cardNum >= 0 && cardNum < cardNumber)
                return cards[cardNum];
            else
                throw new Exception("Card value must be between 0 and " + (cardNumber - 1) + ".");
    }

    public final int getCardNumber() {
        return cardNumber;
    }

    public final void shuffle() {
        Card[] newDeck = new Card[cardNumber];
        boolean[] assigned = new boolean[cardNumber];
        Random sourceGen = new Random();
        for (int i = 0; i < cardNumber; i++) {
            int destCard = 0;
            boolean foundCard = false;
            while (foundCard == false) {
                destCard = sourceGen.nextInt(cardNumber);
                if (!assigned[destCard])
                    foundCard = true;
            }
            assigned[destCard] = true;
            newDeck[destCard] = cards[i];
        }
        cards = newDeck.clone();
    }
}
