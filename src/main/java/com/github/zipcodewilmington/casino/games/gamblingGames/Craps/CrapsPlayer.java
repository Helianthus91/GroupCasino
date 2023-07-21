package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import java.util.Scanner;

public class CrapsPlayer {
    private String name;
    private int balance;

    public CrapsPlayer(String name, int initialBalance) {
        this.name = name;
        this.balance = initialBalance;
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
}
