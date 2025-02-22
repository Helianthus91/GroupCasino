package com.github.zipcodewilmington.casino.games.gamblingGames.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {


    private final String accountName;
    private final String accountPassword;
    private int balance = 0;

    private CasinoAccount arcadeAccount;


    public SlotsPlayer(){
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

    public CasinoAccount getArcadeAccount(){

        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

}