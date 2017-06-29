package main.java.cy.poker.Texas;

import main.java.cy.poker.deck.Card;
import main.java.cy.poker.deck.Deck;

/**
 * Created by anima on 2017/4/3.
 */
public class RandomTexas {
    private SubDeckTexas subDeck;
    private float[] probability;
    private final static int RANDOMTIMES = 200000;

    public RandomTexas(Card[] cards, int playerNumber, int mod) throws Exception {
        subDeck = new SubDeckTexas(cards);
        probability = new float[playerNumber];
        MaxTexas[] maxDegrees = new MaxTexas[playerNumber];

        DegreeTexas degreeOne, degreeTwo;
        Card[][] playerCards = new Card[playerNumber][7];
       // Card[][] cardsTwo = new Card[7];

        for (int i = 0; i < playerNumber; i++) {
            playerCards[i][0] = cards[2*i];
            playerCards[i][1] = cards[2*i + 1];
            for (int j = 0; j < mod; j++) {
                playerCards[i][j + 2] = cards[2*playerNumber + j];
            }
        }

        int maxPlayer = 0;
        int equalNumber = 1;
        System.out.println();

        if (mod == 4) {
            for (int i = 0; i < subDeck.getCardNumber(); i++) {
                for (int j = 0; j < playerNumber; j++) {
                    playerCards[j][2 + mod] = subDeck.getCard(i);
                    maxDegrees[j] = new MaxTexas(playerCards[j]);
                }

                maxPlayer = 0;
                equalNumber = 1;
                for (int k = 1; k < playerNumber; k++) {
                    if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) > 0) {
                        equalNumber = 1;
                        maxPlayer = k;
                    }
                    else if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) == 0)
                        equalNumber++;
                }

                if (equalNumber != 1) {
                    for (int k = 0; k < playerNumber; k++) {
                        if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) == 0)
                            probability[k] += 1.0f/(float)equalNumber;
                    }
                }
                else
                    probability[maxPlayer] += 1.0f;
            }
            for (int i = 0; i < playerNumber; i++)
                probability[i] /= subDeck.getCardNumber();
        }
        else if (mod == 3) {
            for (int i = 0; i < subDeck.getCardNumber(); i++) {
                Card[] deleteCards = new Card[playerNumber*2 + mod + 1];
                deleteCards[playerNumber*2 + mod] = subDeck.getCard(i);
                for (int j = 0; j < playerNumber*2 + mod; j++) {
                    deleteCards[j] = cards[j];
                }

                SubDeckTexas mod3Deck = new SubDeckTexas(deleteCards);

                for (int j = 0; j < mod3Deck.getCardNumber(); j++) {
                    for (int k = 0; k < playerNumber; k++) {
                        playerCards[k][5] = deleteCards[playerNumber*2 + mod];
                        playerCards[k][6] = mod3Deck.getCard(j);
                        maxDegrees[k] = new MaxTexas(playerCards[k]);
                    }

                    maxPlayer = 0;
                    equalNumber = 1;
                    for (int k = 1; k < playerNumber; k++) {
                        if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) > 0) {
                            equalNumber = 1;
                            maxPlayer = k;
                        }
                        else if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) == 0)
                            equalNumber++;
                    }

                    if (equalNumber != 1) {
                        for (int k = 0; k < playerNumber; k++) {
                            if (maxDegrees[k].getMaxDegree().isGreaterThan(maxDegrees[maxPlayer].getMaxDegree()) == 0)
                                probability[k] += 1.0f/(float)equalNumber;
                        }
                    }
                    else
                        probability[maxPlayer] += 1.0f;
                }
            }
            for (int i = 0; i < playerNumber; i++) {
                probability[i] /= (subDeck.getCardNumber()*(subDeck.getCardNumber() - 1));
            }
        }


    }

    public final float[] getProbability() {
        return probability;
    }
}
