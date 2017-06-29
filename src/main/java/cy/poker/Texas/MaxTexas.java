package main.java.cy.poker.Texas;

import main.java.cy.poker.Texas.DegreeTexas;
import main.java.cy.poker.deck.Card;

/**
 * Created by anima on 2017/4/1.
 */
public class MaxTexas {
    private final static int POSSIBILITY = 21;
    private DegreeTexas maxDegree;

    public MaxTexas(Card[] sevenCards) {
        int count = 0;
        Card[] fiveCards = new Card[5];
        DegreeTexas[] degrees = new DegreeTexas[POSSIBILITY];

        for (int a = 0; a < 3; a++) {
            for (int b = a + 1; b < 4; b++) {
                for (int c = b + 1; c < 5; c++) {
                    for (int d = c + 1; d < 6; d++) {
                        for (int e = d + 1; e < 7; e++) {
                            fiveCards[0] = sevenCards[a];
                            fiveCards[1] = sevenCards[b];
                            fiveCards[2] = sevenCards[c];
                            fiveCards[3] = sevenCards[d];
                            fiveCards[4] = sevenCards[e];
                            degrees[count] = new DegreeTexas(fiveCards);
                            count++;
                        }
                    }
                }
            }
        }

        maxDegree = degrees[0];
        for (int i = 1; i < POSSIBILITY; ++i) {
            if (degrees[i].isGreaterThan(maxDegree) > 0)
                maxDegree = degrees[i];
        }
    }

    public final DegreeTexas getMaxDegree() {
        return maxDegree;
    }
}
