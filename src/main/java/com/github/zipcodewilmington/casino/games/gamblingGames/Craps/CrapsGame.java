package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Random;
import java.util.Scanner;

public class CrapsGame extends GamblingGame {
    private int rollDice() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type any key to roll!");
        String roll = scanner.nextLine();
        return random.nextInt(11) + 2;
    }

    public void gameIntro() {
        System.out.println("Welcome to Craps Casino Game!");


    }

    // startGame = entry point to casino game that starts game loop and repeatedly calls playRound method.
    public void run() {

       do {
           boolean reroll = true;
           gameIntro();
           int firstRoll = rollDice();
           int sum = firstRoll;
           System.out.println("You rolled a " + firstRoll);

           if (sum == 7 || sum == 11) {
               System.out.println("Congratulations, you win!");
           } else if (sum == 2 || sum == 3 || sum == 12) {
               System.out.println("Oh no, you lose!");
           } else {
               System.out.println("The point is " + sum);
               while (reroll) {
                   int nextRoll = rollDice();
                   System.out.println("You rolled a " + nextRoll);
                   if (nextRoll == sum) {
                       System.out.println("Congratulations, you win!");
                       reroll = false;
//                       playAgain();
                   } else if (nextRoll == 7) {
                       System.out.println("Oh no, you lose!");
                       reroll = false;
//                       playAgain();

                   }
               }
           }
       } while (playAgain());
        // core logic of the game within a single round
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

    private boolean playAgain () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Play again? (Y/N)");
            String playAgain = scanner.nextLine();
            return playAgain.equalsIgnoreCase("Y");
        }
        // allows user to play again if they desire
        public static void main (String[]args){
            CrapsGame crapsGame = new CrapsGame();
            crapsGame.run();
        }

    @Override
    public void playerBet() {

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