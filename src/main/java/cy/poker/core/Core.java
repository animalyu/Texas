package main.java.cy.poker.core;

import main.java.cy.poker.Texas.DeckTexas;
import main.java.cy.poker.Texas.DegreeTexas;
import main.java.cy.poker.Texas.RandomTexas;
import main.java.cy.poker.deck.Card;
import main.java.cy.poker.Texas.MaxTexas;
import main.java.cy.poker.deck.Suit;

/**
 * Created by anima on 2017/3/24.
 */
public class Core {
    public static void main(String[] args) throws Exception {
        /*Deck adeck = new Deck();
        for(int i = 0; i < adeck.getCardNumber(); i++) {
            System.out.println(adeck.getCard(i).toString());
        }
        Chip five = new Chip(5, 7);
        Chip ten = new Chip(10, 5);
        Chips pots = new Chips();
        Chips own = new Chips();
        own.addChip(ten);
        //Player play1 = new Player(own);
        System.out.println("Start with: " + pots.getTotalAmount());
        //int left = play1.bet(pots, five);
        System.out.println("End with: " + pots.getTotalAmount());
        //System.out.println("The player own: " + left);

        DeckTexas adeck = new DeckTexas();
        Card[] acard = new Card[7];
        int[] arank = new int[9];

        for(int i = 0; i < 1000000; i++) {
            adeck.shuffle();

            acard[0] = adeck.getCard(0);
            acard[1] = adeck.getCard(1);
            acard[2] = adeck.getCard(2);
            acard[3] = adeck.getCard(3);
            acard[4] = adeck.getCard(4);
            acard[5] = adeck.getCard(5);
            acard[6] = adeck.getCard(6);

            //System.out.println(acard[0].toString());
            //System.out.println(acard[1].toString());
            //System.out.println(acard[2].toString());
            //System.out.println(acard[3].toString());
            //System.out.println(acard[4].toString());
            //System.out.println(acard[5].toString());
            //System.out.println(acard[6].toString());

            MaxTexas max = new MaxTexas(acard);

            DegreeTexas adegree = max.getMaxDegree();
            //System.out.println(adegree.getCardsRanking());
            arank[adegree.getCardsRanking() - 1]++;
        }
        for(int i = 0; i < 9; i++)
            System.out.println((float)arank[i]/10000);*/

        DeckTexas newDeck = new DeckTexas();
        newDeck.shuffle();
        Card[] cards = new Card[7];
        for (int i = 0; i < 7; i++) {
            cards[i] = newDeck.getCard(i);
            System.out.println(cards[i].toString());
        }
        RandomTexas xd = new RandomTexas(cards, 2, 3);

        float[] results = xd.getProbability();

        System.out.println(results[0]*100);
        System.out.println(results[1]*100);

    }
}
