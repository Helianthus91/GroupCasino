package com.github.zipcodewilmington.casino.games.slots;


import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {

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

    public void gameIntro(){
        System.out.println("Welcome to SLOTS");
    }

    public void playerBet(){

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
