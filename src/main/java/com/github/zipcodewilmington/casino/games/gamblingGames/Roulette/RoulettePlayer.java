package com.github.zipcodewilmington.casino.games.gamblingGames.Roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RoulettePlayer implements PlayerInterface {

    private final String accountName;
    private final String accountPassword;
    private int balance = 0;

    private CasinoAccount arcadeAccount;


    public RoulettePlayer(){
        this.balance = CasinoAccount.getBalance();
        this.accountName = CasinoAccount.getName();
        this.accountPassword = CasinoAccount.getPassword();

    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
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
