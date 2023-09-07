package com.github.zipcodewilmington.casino.games.gamblingGames.Roulette;

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

    private int spinResult; // Store the spin result here

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
            performSpin(); // Perform the spin once
            evaluateResult(prediction);
            System.out.println("CURRENT BALANCE: $" + balance); // Show balance after each spin
        }
        outro();
    }

    public void outro() {
        System.out.println("\nTHANK YOU 4 YOUR DONATION!!");
        System.out.println("YOU FINISHED WITH $" + balance);
        scanner.close();
    }

    public void Intro() {
        System.out.print("WELCOME TO ROULETTE!\n");
        System.out.print("YOU HAVE $" + balance + " TO GAMBLE!\n");
        System.out.print("ENTER 0 AT ANYTIME TO CASH OUT!\n");
    }

    public void placeBet() {
        System.out.print("\nPLACE BET!");
        betAmount = scanner.nextInt();
    }

    public String askForPrediction() {
        System.out.println("WHAT'S YOUR PREDICTION? (odd/even):");
        return scanner.next().toLowerCase();
    }

    public void performSpin() {
        spinResult = random.nextInt(37); // Store the spin result
    }

    public void evaluateResult(String prediction) {
        if (betAmount == 0) {
            System.out.println("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!");
            return;
        }

        System.out.println("SPIN RESULT: " + spinResult); // Use the stored spin result

        if ((spinResult % 2 == 0 && prediction.equalsIgnoreCase("even")) || (spinResult % 2 != 0 && prediction.equalsIgnoreCase("odd"))) {
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
    public int calculateWinnings() {
        return 0;
    }

    @Override
    public int calculateWinner() {
        return 0;
    }
}
