package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Random;
import java.util.Scanner;

public class CrapsGame extends GamblingGame {

    private CrapsPlayer player;
    private int bet;

    // startGame = entry point to casino game that starts game loop and repeatedly calls playRound method.
    public void run() {

       do {
           boolean reroll = true;
           gameIntro();
           bet = playerBet();

           int firstRoll = rollDice();
           int sum = firstRoll;
           System.out.println("You rolled a " + firstRoll);

           if (sum == 7 || sum == 11) {
               System.out.println("Congratulations, you win!");
               winCheck();
               calculateWinnings();
               updateBalance();
           } else if (sum == 2 || sum == 3 || sum == 12) {
               System.out.println("Oh no, you lose!");
               loseCheck();
               calculateWinnings();
               updateBalance();
           } else {
               System.out.println("The point is " + sum);
               while (reroll) {
                   int nextRoll = rollDice();
                   System.out.println("You rolled a " + nextRoll);
                   if (nextRoll == sum) {
                       System.out.println("Congratulations, you win!");
                       winCheck();
                       calculateWinnings();
                       updateBalance();
                       reroll = false;
//                       playAgain();
                   } else if (nextRoll == 7) {
                       System.out.println("Oh no, you lose!");
                        loseCheck();
                        calculateWinnings();
                        updateBalance();
                       reroll = false;
//                       playAgain();

                   }
               }
           }
       } while (playAgain());
        // core logic of the game within a single round
    }

    private int rollDice() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter (return) to roll!");
        String roll = scanner.nextLine();
        return random.nextInt(11) + 2;
    }

    public void gameIntro() {
        add();
        System.out.println("Welcome to Craps Casino Game!");



    }

    @Override
    public void intro() {

    }

    @Override
    public boolean winCheck() {
        return true;
    }

    public boolean loseCheck(){
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
    public int playerBet(){
        System.out.println("Your current balance is: " + player.getBalance());
        bet = console.getIntegerInput("Please enter how much you would like to bet: ");
        return bet;
    }

   public int calculateWinnings() {
        if (winCheck()){
            return (bet * 10);
        } else {
            return bet * -1;
        }
   }

    @Override
    public void updateBalance() {
        bet = calculateWinnings();
     int newBalance = player.getBalance() + bet;
            player.setBalance(newBalance);}

    @Override
    public int calculateWinner() {
        return 0;
    }
    public void add(){
        this.player = new CrapsPlayer();
    }

    public void remove(CrapsPlayer player){
        this.player = null;
    }


}