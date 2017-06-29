package main.java.cy.poker.Texas;

import main.java.cy.poker.chip.Chips;
import main.java.cy.poker.deck.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anima on 2017/3/27.
 */
public class GameTexas {
    private List<PlayerTexas> players = new ArrayList<PlayerTexas>();
    private DeckTexas deck = new DeckTexas();
    private Card[] theFlop;
    private Card theTurn;
    private Card theRiver;
    private int deckLocation = 0;

    public GameTexas() {
        System.out.println("Game begin!");
        deck.shuffle();
    }

    public void addPlayer(String playerName, int playerID) {
        players.add(new PlayerTexas(playerName, playerID));
    }

    public void addChips(String playerName, Chips newChips) throws Exception {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getName() == playerName) {
                players.get(i).addChips(newChips);
                return;
            }
        }
        throw new Exception("Could not find " + playerName);
    }

    public void giveCards() throws Exception {
        int turn = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getID() == turn) {
                players.get(i).giveCard(deck.getCard(deckLocation));
                deckLocation++;
                turn++;
                i = 0;
            }
        }
        turn = 0;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getID() == turn) {
                players.get(i).giveCard(deck.getCard(deckLocation));
                deckLocation++;
                turn++;
                i = 0;
            }
        }
    }

    public final Card[] getFlop() throws Exception {
        deckLocation++;
        theFlop = new Card[3];
        theFlop[0] = deck.getCard(deckLocation++);
        theFlop[1] = deck.getCard(deckLocation++);
        theFlop[2] = deck.getCard(deckLocation++);
        return theFlop;
    }

    public final Card getTurn() throws Exception {
        deckLocation++;
        theTurn = deck.getCard(deckLocation++);
        return theTurn;
    }

    public final Card getTheRiver() throws Exception {
        deckLocation++;
        theRiver = deck.getCard(deckLocation);
        return theRiver;
    }

    public final void playerRotate() {
        for (int i = 0; i < players.size() - 1; i++) {
            players.get(i).rotate();
        }
        players.get(players.size() - 1).playerRotateFinalOne();
    }
}
