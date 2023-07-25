package com.github.zipcodewilmington.casino.games.gamblingGames.Roulette;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Scanner;
import java.util.Random;
public class RouletteGame extends GamblingGame {
    public static void main(String[] args) {
        new RouletteGame().run();
    }
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    public int balance = 1000;
    public int betAmount;


    public void run() {
        Intro();
        while (balance > 0) {
            placeBet();
            if (betAmount == 0) {
                System.out.println("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!");
                break;
            }
            if (betAmount > balance) {
                System.out.println("Relax, YOU DON'T HAVE ENOUGH MONEY! HIT THE ATM ASAP!");
                continue;

            }
            String prediction = askForPrediction();
            performSpin();
            evaluateResult(prediction);
        }
        outro();
    }
    public void outro(){
        System.out.println("\nTHANK YOU 4 YOUR DONATION!!");
        System.out.println("YOU FINISHED WITH $" + balance);
        scanner.close();
    }
    public void Intro(){
        System.out.print("WELCOME TO ROULETTE!\n");
        System.out.print("YOU HAVE $" + balance + " TO GAMBLE!\n");
    }
    public void placeBet() {
        System.out.print("\nPLACE BET!");
        betAmount = scanner.nextInt();
    }
    public String askForPrediction() {
        System.out.println("WHATS YOUR PREDICTION? (odd/even):");
        return scanner.next().toLowerCase();
    }
    public void performSpin() {
        int spin = random.nextInt(37);
        System.out.println("SPIN RESULT: " + spin);
    }
    public void evaluateResult(String prediction) {
        if (betAmount == 0) {
            System.out.println("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!");
            return;
        }
        int spin = random.nextInt(37);
        System.out.println("SPIN RESULT: " + spin);
        if ((spin % 2 == 0 && prediction.equalsIgnoreCase("even")) || (spin % 2 != 0 && prediction.equalsIgnoreCase("odd"))) {
            System.out.println("GREAT GUESS! YOU WON $" + betAmount + " DOLLARS!");
            balance += betAmount;
        } else {
            balance -= betAmount;
            System.out.println("SORRY MAYBE NEXT TIME! YOU LOST $" + betAmount + " DOLLARS");
        }
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
    public void updateBalance() {

    }
    @Override
    public void updateBalance() {

    }
    @Override
    public int calculateWinner() {
        return 0;
    }
}
