package com.github.zipcodewilmington.casino.games.gamblingGames.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;

import java.util.Scanner;
import java.util.Random;
public class RouletteGame extends GamblingGame {

    public RoulettePlayer player;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int balance;
    int bet;
    private boolean playing = true;


    public void run() {
        int spin = random.nextInt(37);
        System.out.print("WELCOME TO ROULETTE!\n");
        System.out.print("YOU HAVE $" + balance + " TO GAMBLE!\n");
        while (balance > 0){
            System.out.print("\nPLACE BET!");
            bet= scanner.nextInt();
            if (bet == 0) {System.out.println("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!" );
                break;}
            if (bet > balance) {
                System.out.println("Relax, YOU DON'T HAVE ENOUGH MONEY! HIT THE ATM ASAP!");
                continue;}
            System.out.println("WHATS YOUR PREDICTION? (odd/even):");
            String prediction = scanner.next().toLowerCase();
            if (spin % 2 == 0 && prediction.equalsIgnoreCase("even")) {
                System.out.println("GREAT GUESS! YOU WON" + bet + " DOLLARS!");
                balance += bet;}
            else if (spin % 2 != 0 && prediction.equalsIgnoreCase("odd")) {
                System.out.println("GREAT GUESS! YOU WON" + bet + " DOLLARS!");
                balance += bet;}
            else {balance -= bet;
                System.out.println("SORRY MAYBE NEXT TIME! YOU LOST " + bet + " DOLLARS");
            }
        }
        System.out.println("\nTHANK YOU 4 YOUR DONATION!!");
        System.out.println("YOU FINISHED WITH $" + balance);
        scanner.close();
    }

    @Override
    public void intro() {

    }

    @Override
    public boolean winCheck() {
        return false;
    }

    @Override
    public void quitAsk() {
        if (winCheck() == true) {
            System.out.println("You have won $" + bet + "!");
        } else {
            System.out.println("Sorry, no win this time.");
        }

        String userAnswer = console.getStringInput("Would you like to spin again? Press 'y' to play again. Press 'n' to quit the game.");


        if (userAnswer.equals("y")) {
            playing = true;
        } else {
            playing = false;
        }

        CasinoAccount.setBalance(player.getBalance());
        String accountName = player.getArcadeAccount().getName();
        String accountPassword = player.getArcadeAccount().getPassword();
        Integer accountBalance = player.getBalance();
        updateSelectedAccount(accountName, accountPassword, accountBalance);
    }

    public void add(){
        this.player = new RoulettePlayer();

    }

    public void remove(RoulettePlayer player){
        this.player = null;
    }

    public RoulettePlayer getPlayer(){
        return player;
    }

    @Override
    public int playerBet() {
        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        return temp;
    }

    @Override
    public void updateBalance() {

    }

    @Override
    public int calculateWinnings(){
        return 0;
    }

    public int calculateWinnings(Integer bet, Boolean wonGame) {
        return 0;
    }

    @Override
    public int calculateWinner() {
        return 0;
    }
}