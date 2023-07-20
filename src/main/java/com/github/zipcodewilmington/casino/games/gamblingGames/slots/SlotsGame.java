package com.github.zipcodewilmington.casino.games.gamblingGames.slots;


import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends GamblingGame {

    public SlotsPlayer player;

    private int bet;

    private String[] slotOptions = new String[]{"*", "~", "@", "#", "o", "+"};

    private String[] slotResult = new String[3];

    private IOConsole console = new IOConsole();

    private IOConsole colorConsole = new IOConsole(AnsiColor.RED);

    private boolean playing = true;


    public static void main(String[] args) throws InterruptedException {
        new SlotsGame().run();
    }



    public void add(SlotsPlayer player){
        this.player = player;
    }

    public void remove(SlotsPlayer player){
        this.player = null;
    }

    public void run(){
        intro();


        while (playing == true) {
            // Get player bet
            playerBet();

            // Spin slots
            startSlots();
            slotResult();
            try {
                printSlotResult();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Update bet based on result of spin
            calculateWinnings();
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

    @Override
    public boolean winCheck() {
        if (slotResult[0].equals(slotResult[1]) && slotResult[1].equals(slotResult[2])){
            return true;
        }
        else {
            return false;
        }
    }


    public void playerBet(){
        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        bet = temp;
    }

    @Override
    public int calculateWinnings() {
        if (winCheck() == true){
            return (bet * 10);
        }
        else {
            return (bet * -1);
        }
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

    public void slotResult(){
        for (int i = 0; i < 3; i++){
            slotResult[i] = slotTurn();
        }
    }

    public void printSlotResult() throws InterruptedException {
        for (String s : slotResult){
            for (int i = 0; i < slotOptions.length; i++){
                colorConsole.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b");
            }
            for (int i = 0; i < slotOptions.length; i++){
                System.out.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b");
            }
            for (int i = 0; i < slotOptions.length; i++){
                System.out.print(slotOptions[i]);
                Thread.sleep(100);
                System.out.print("\b");
            }
            Thread.sleep(200);
            colorConsole.print(s + " ");
            Thread.sleep(500);
        }
        console.print("\n");
    }




    public void quitAsk(){
        if (winCheck() == true){
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
    }











}
