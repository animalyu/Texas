package main.java.cy.poker.Texas;

import main.java.cy.poker.deck.Card;

import java.util.Arrays;

/**
 * Created by anima on 2017/3/28.
 */
public class DegreeTexas {
    private int cardsRanking;
    private int[] cardsValue;
    private int[] keyValue;

    public DegreeTexas(Card[] cards) {
        keyValue = new int[5];
        Boolean isFlush = true;
        for (int i = 1; i < 5; i++) {
            if (!cards[0].sameSuit(cards[i]))
                isFlush = false;
        }

        cardsValue = new int[5];
        for (int i = 0; i < 5; i++)
            cardsValue[i] = cards[i].getRank();
        Arrays.sort(cardsValue);
        if (isFlush)
            keyValue = cardsValue.clone();

        if (isStraight()) {
            if (isFlush) {
                cardsRanking = 9;  // Straight Flush
                keyValue = cardsValue.clone();
            }
            else {
                cardsRanking = 5;  // Straight
                keyValue = cardsValue.clone();
            }
        }
        else if (isFlush) {
            cardsRanking = 6;  // Flush
            keyValue = cardsValue.clone();
        }
        else if (cardsValue[3] == cardsValue[0] || cardsValue[4] == cardsValue[1]) {
            cardsRanking = 8;  // Four Of A Kind
            if (cardsValue[3] == cardsValue[0]) {
                keyValue[1] = keyValue[2] = keyValue[3] = keyValue[4] = cardsValue[0];
                keyValue[0] = cardsValue[4];
            }
            else
                keyValue = cardsValue.clone();
        }
        else if ((cardsValue[2] == cardsValue[0] && cardsValue[3] == cardsValue[4]) ||
                (cardsValue[1] == cardsValue[0] && cardsValue[2] == cardsValue[4])) {
            cardsRanking = 7;  // Full House
            if (cardsValue[2] == cardsValue[0]) {
                keyValue[2] = keyValue[3] = keyValue[4] = cardsValue[0];
                keyValue[0] = keyValue[1] = cardsValue[3];
            }
            else
                keyValue = cardsValue.clone();
        }
        else if (cardsValue[0] == cardsValue[2] || cardsValue[1] == cardsValue[3] ||
                cardsValue[2] == cardsValue[4]) {
            cardsRanking = 4;  // Three Of A Kind
            if (cardsValue[2] == cardsValue[0]) {
                keyValue[2] = keyValue[3] = keyValue[4] = cardsValue[0];
                keyValue[0] = cardsValue[3];
                keyValue[1] = cardsValue[4];
            }
            else if (cardsValue[1] == cardsValue[3]) {
                keyValue[2] = keyValue[3] = keyValue[4] = cardsValue[1];
                keyValue[0] = cardsValue[0];
                keyValue[1] = cardsValue[4];
            }
            else
                keyValue = cardsValue.clone();
        }
        else if ((cardsValue[0] == cardsValue[1] && cardsValue[2] == cardsValue[3]) ||
                cardsValue[0] == cardsValue[1] && cardsValue[3] == cardsValue[4] ||
                cardsValue[1] == cardsValue[2] && cardsValue[3] == cardsValue[4]) {
            cardsRanking = 3;  // Two Pair
            if (cardsValue[0] == cardsValue[1] && cardsValue[2] == cardsValue[3]) {
                keyValue[0] = cardsValue[4];
                keyValue[1] = keyValue[2] = cardsValue[0];
                keyValue[3] = keyValue[4] = cardsValue[2];
            }
            else if (cardsValue[0] == cardsValue[1] && cardsValue[3] == cardsValue[4]) {
                keyValue[0] = cardsValue[2];
                keyValue[1] = keyValue[2] = cardsValue[0];
                keyValue[3] = keyValue[4] = cardsValue[3];
            }
            else
                keyValue = cardsValue.clone();
        }
        else if (cardsValue[0] == cardsValue[1] || cardsValue[1] == cardsValue[2] ||
                cardsValue[2] == cardsValue[3] || cardsValue[3] == cardsValue[4]) {
            cardsRanking = 2;  // One Pair
            if (cardsValue[0] == cardsValue[1]) {
                keyValue[0] = cardsValue[2];
                keyValue[1] = cardsValue[3];
                keyValue[2] = cardsValue[4];
                keyValue[3] = keyValue[4] = cardsValue[0];
            }
            else if (cardsValue[1] == cardsValue[2]) {
                keyValue[0] = cardsValue[0];
                keyValue[1] = cardsValue[3];
                keyValue[2] = cardsValue[4];
                keyValue[3] = keyValue[4] = cardsValue[1];
            }
            else if (cardsValue[2] == cardsValue[3]) {
                keyValue[0] = cardsValue[0];
                keyValue[1] = cardsValue[1];
                keyValue[2] = cardsValue[4];
                keyValue[3] = keyValue[4] = cardsValue[2];
            }
            else
                keyValue = cardsValue.clone();
        }
        else {
            cardsRanking = 1;  // High Cards;
            keyValue = cardsValue.clone();
        }
    }

    private Boolean isStraight() {
        if (Arrays.equals(cardsValue, new int[] { 2, 3, 4, 5, 14 })) {
            return true;
        }
        else if (cardsValue[1] - cardsValue[0] == 1 &&
                    cardsValue[2] - cardsValue[1] == 1 &&
                    cardsValue[3] - cardsValue[2] == 1 &&
                    cardsValue[4] - cardsValue[3] == 1)
            return true;
        return false;
    }

    public int getCardsRanking() {
        return cardsRanking;
    }

    public int isGreaterThan(DegreeTexas anotherDegree) {
        if (this.cardsRanking > anotherDegree.cardsRanking)
            return 1;
        else if (this.cardsRanking == anotherDegree.cardsRanking) {
            for (int i = 0; i < 5; i++) {
                if (this.keyValue[4 - i] < anotherDegree.keyValue[4 - i])
                    return -1;
                else if (this.keyValue[4 - i] > anotherDegree.keyValue[4 - i])
                    return 1;
            }
            return 0;
        }
        return -1;
    }
}
