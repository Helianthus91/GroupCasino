package com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class RockPaperScissorsPlayer implements PlayerInterface {
    private int balance = 0;

    private CasinoAccount arcadeAccount;



    public RockPaperScissorsPlayer(){
        this.balance = CasinoAccount.getBalance();

    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public CasinoAccount getArcadeAccount(){

        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
