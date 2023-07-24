package com.github.zipcodewilmington.casino.games.gamblingGames.slots;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends GamblingGame {

    public SlotsPlayer player;
    private int bet;

    private String[] slotOptions = new String[]{"***", "~~~", "###", "ooo", "+++"};

    private String[] slotResult = new String[3];
    private IOConsole console = new IOConsole();
    private IOConsole colorConsole = new IOConsole(AnsiColor.RED);
    private boolean wonGame;
    private boolean playing = true;


    public void add(){
        this.player = new SlotsPlayer();

    }

    public void remove(SlotsPlayer player){
        this.player = null;
    }

    public SlotsPlayer getPlayer(){
        return player;
    }

    public void run(){
        add();
        intro();



        while (playing == true) {
            System.out.println("Your current balance is: " + player.getBalance());

            // Get player bet
            bet = playerBet();

            // Spin slots
            startSlots();
            slotResult = slotResult();
            try {
                printSlotResult();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            wonGame = winCheck(slotResult);
            // Update bet based on result of spin
            bet = calculateWinnings(bet, wonGame);
            // Update player balance with new bet

            updateBalance();
            quitAsk();
        }

    }

    @Override
    public void intro() {

        System.out.println("Welcome to SLOTS");
        System.out.println("If you get 3 in a row, you win!");

    }

    public int getBet(){
        return bet;
    }

    @Override
    public boolean winCheck(){
        return true;
    }




    public boolean winCheck(String[] slotResult) {
        if (slotResult.length != 3) {
            return false;
        }
        return (slotResult[0].equals(slotResult[1]) && slotResult[1].equals(slotResult[2]));

    }

    @Override
    public int playerBet(){

        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        return temp;
    }




    @Override
    public int calculateWinnings(){
        return 0;
    }

    public int calculateWinnings(int bet, boolean wonGame) {
        if (wonGame){
            return (bet * 10);
        }
        else {
            return (bet * -1);
        }
    }



    @Override
    public int calculateWinner() {
        return 0;
    }

    public void updateBalance(){

        int newBalance = player.getBalance() + bet;
        player.setBalance(newBalance);

    }

    public void startSlots(){
        console.getStringInput("Press the return key to spin the slots and (possibly) win some money!");
    }

    public String slotTurn(){
        Random rand = new Random();
        String slot = "";

        slot = slotOptions[rand.nextInt(slotOptions.length - 1)];

        return slot;
    }

    public String[] slotResult(){
        String[] result = new String[3];
        for (int i = 0; i < 3; i++){
            result[i] = slotTurn();
        }
        return result;
    }

    public void printSlotResult() throws InterruptedException {
        for (String s : slotResult){
            for (int i = 0; i < slotOptions.length; i++){
                colorConsole.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b\b\b");
            }
            for (int i = 0; i < slotOptions.length; i++){
                System.out.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b\b\b");
            }
            for (int i = 0; i < slotOptions.length; i++){
                System.out.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b\b\b");
            }
            Thread.sleep(100);
            colorConsole.print(s + " ");
            Thread.sleep(500);
        }
        console.print("\n");
    }




    public void quitAsk(){
        if (wonGame){
            System.out.println("You have won $" + bet + "!");
        }
        else {
            System.out.println("Sorry, no win this time.");
        }

        String userAnswer = console.getStringInput("Would you like to spin again? Press 'y' to play again. Press 'n' to quit the game.");

        if (userAnswer.equals("y")){
            playing = true;
        }
        else {
            playing = false;
        }

        CasinoAccount.setBalance(player.getBalance());
        String accountName = player.getArcadeAccount().getName();
        String accountPassword = player.getArcadeAccount().getPassword();
        Integer accountBalance = player.getBalance();
        updateSelectedAccount(accountName, accountPassword, accountBalance);

    }

}

