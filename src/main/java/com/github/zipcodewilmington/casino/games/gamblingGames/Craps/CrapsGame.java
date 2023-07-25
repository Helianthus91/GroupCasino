package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;

import java.util.Random;
import java.util.Scanner;

public class CrapsGame extends GamblingGame {

    private CrapsPlayer player;
    private int bet;



    private boolean wonGame;

    private boolean playing = true;

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
               wonGame = winCheck();
               bet = calculateWinnings(bet, wonGame);
               updateBalance();
               CasinoAccount.setBalance(player.getBalance());
           } else if (sum == 2 || sum == 3 || sum == 12) {
               System.out.println("Oh no, you lose!");
               wonGame = loseCheck();
               bet = calculateWinnings(bet, wonGame);
               updateBalance();
               CasinoAccount.setBalance(player.getBalance());
           } else {
               System.out.println("The point is " + sum);
               while (reroll) {
                   int nextRoll = rollDice();
                   System.out.println("You rolled a " + nextRoll);
                   if (nextRoll == sum) {
                       System.out.println("Congratulations, you win!");
                       wonGame = winCheck();
                       bet = calculateWinnings(bet, wonGame);
                       updateBalance();
                       CasinoAccount.setBalance(player.getBalance());
                       reroll = false;
//
                   } else if (nextRoll == 7) {
                       System.out.println("Oh no, you lose!");
                        wonGame = loseCheck();
                        bet = calculateWinnings(bet, wonGame);
                        updateBalance();
                       CasinoAccount.setBalance(player.getBalance());
                       reroll = false;
//
                   }
               }
           }
           playing = playAgain();
       } while (playing);
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

        intro();


    }

    @Override
    public void intro() {
        System.out.println("Welcome to Craps Casino Game!");
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

    @Override
    public void updateBalance() {
        int newBalance = player.getBalance() + bet;
        player.setBalance(newBalance);}

    @Override
    public int calculateWinnings(){
        return 0;
    }

    public int calculateWinnings(Integer bet, Boolean wonGame) {
        if (wonGame){
            return (bet * 2);
        } else {
            return bet * -1;
        }
    }

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


    public CrapsPlayer getPlayer() {
        return player;
    }



}