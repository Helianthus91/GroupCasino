package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

public class CrapsPlayer implements PlayerInterface {
    private String name;
    private int balance;

    public CrapsPlayer() {

    }

    public void playerBet(int amount) {
        balance -= amount;
    }

    public void winBet() {
        balance += 2 * 25;
    }
    // if the bet is $50, the player doubles their bet
    public void loseBet() {
    }
    // bet deducted
    public int getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
