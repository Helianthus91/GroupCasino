package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

public class CrapsPlayer implements PlayerInterface {
    private int balance;
    private CasinoAccount arcadeAccount;

    public CrapsPlayer() {
        this.balance = CasinoAccount.getBalance();

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
