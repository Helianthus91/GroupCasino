package com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.IOConsole;
import sun.tools.jconsole.JConsole;

import java.util.List;

public class BlackJackPlayer implements PlayerInterface {
    private List<Card> hand;
    private int balance;
    IOConsole console = new IOConsole(AnsiColor.YELLOW);

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public void hit(){
        hand.add(Deck.get(0));
    }

    public int placeBet(){
        int bet = console.getIntegerInput("Enter bet amount : ");
        balance -= bet;
        return bet;
    }

}
