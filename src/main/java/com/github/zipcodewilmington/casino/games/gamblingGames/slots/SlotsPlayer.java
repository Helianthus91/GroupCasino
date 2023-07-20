package com.github.zipcodewilmington.casino.games.gamblingGames.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer {


    private int balance;

    private CasinoAccount arcadeAccount;

    public SlotsPlayer(){

    }

    public SlotsPlayer(int balance){
        this.balance = CasinoAccount.getBalance();

    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void getArcadeAccount(){

    }

}