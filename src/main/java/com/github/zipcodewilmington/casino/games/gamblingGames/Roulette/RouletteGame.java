package com.github.zipcodewilmington.casino.games.gamblingGames.Roulette;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Scanner;
import java.util.Random;
public class RouletteGame extends GamblingGame {
    public static void main(String[] args) {
        new RouletteGame().run();
    }
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int balance = 1000;
    int betAmount;
    public void run() {
        int spin = random.nextInt(37);
        System.out.print("WELCOME TO ROULETTE!\n");
        System.out.print("YOU HAVE $" + balance + " TO GAMBLE!\n");
        while (balance > 0){
            System.out.print("\nPLACE BET!");
            betAmount= scanner.nextInt();
            if (betAmount == 0) {System.out.println("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!" );
                break;}
            if (betAmount > balance) {
                System.out.println("Relax, YOU DON'T HAVE ENOUGH MONEY! HIT THE ATM ASAP!");
                continue;}
            System.out.println("WHATS YOUR PREDICTION? (odd/even):");
            String prediction = scanner.next().toLowerCase();
            if (spin % 2 == 0 && prediction.equalsIgnoreCase("even")) {
                System.out.println("GREAT GUESS! YOU WON" + betAmount + " DOLLARS!");
                balance += betAmount;}
            else if (spin % 2 != 0 && prediction.equalsIgnoreCase("odd")) {
                System.out.println("GREAT GUESS! YOU WON" + betAmount + " DOLLARS!");
                balance += betAmount;}
            else {balance -= betAmount;
                System.out.println("SORRY MAYBE NEXT TIME! YOU LOST " + betAmount + " DOLLARS");
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

    }

    @Override
    public int playerBet() {

        return 0;
    }

    @Override
    public int calculateWinnings() {
        return 0;
    }

    @Override
    public void updateBalance() {

    }

    @Override
    public int calculateWinner() {
        return 0;
    }
}