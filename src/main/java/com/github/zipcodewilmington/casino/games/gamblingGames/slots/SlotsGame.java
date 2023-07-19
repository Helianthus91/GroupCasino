package com.github.zipcodewilmington.casino.games.gamblingGames.slots;


import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends GamblingGame {

    public SlotsPlayer player;

    private int bet;

    private int winnings;

    private String slotResult;





    public void add(SlotsPlayer player){
        this.player = player;
    }

    public void remove(SlotsPlayer player){
        this.player = null;
    }

    public void run(){

    }

    @Override
    public void intro() {

    }

    @Override
    public boolean winCheck() {
        return false;
    }

    public void gameIntro(){
        System.out.println("Welcome to SLOTS");
    }

    public void playerBet(){

        bet = 9;

    }

    @Override
    public int calculateWinner() {
        return 0;
    }

    public String slotTurn(){
        Random rand = new Random();


        return "";
    }

    public void slotResult(){

    }

    public boolean winCheck(String slotResult){
        return true;
    }

    public void updateBalance(){

    }

    public void quitAsk(){

    }











}
