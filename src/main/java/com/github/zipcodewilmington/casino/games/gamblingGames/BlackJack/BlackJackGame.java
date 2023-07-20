package com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack;

import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.Deck;

public class BlackJackGame extends GamblingGame {
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private Deck[] deckOfCards;
    private int bet;
    private int winnings;

    @Override
    public void run() {


    }

    @Override
    public void intro() {
        System.out.println("Welcome to the BlackJack" + "\n");
        System.out.println("Place your bet at the table to begin");

    }

    @Override
    public boolean winCheck() {
        return false;
    }

    @Override
    public void quitAsk() {

    }

    @Override
    public void playerBet() {
//        int theBet = player.placeBet();

    }

    @Override
    public int calculateWinnings() {
        return 0;
    }

    @Override
    public int calculateWinner() {
        return 2;
    }

    @Override
    public void updateBalance() {

    }

}
