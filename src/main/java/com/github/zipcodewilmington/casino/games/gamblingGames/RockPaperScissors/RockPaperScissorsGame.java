package com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

public class RockPaperScissorsGame extends GamblingGame {
    protected static final String ROCK = "rock";
    protected static final String PAPER = "paper";
    protected static final String SCISSOR = "scissor";

    public RockPaperScissorsPlayer player;

    public RockPaperScissorsPlayer dealer;

    private String dealerThrow;
    private String playerThrow;

    private int bet;

    private IOConsole console = new IOConsole();

    private IOConsole colorConsole = new IOConsole(AnsiColor.RED);

    private boolean playing = true;


    public void add(){
        this.player = new RockPaperScissorsPlayer();
    }

    public void remove(RockPaperScissorsPlayer player){
        this.player = null;
    }

    public void run() {
        add();
        intro();


    }

    @Override
    public void intro() {

        System.out.println("Welcome to ROCK PAPER SCISSORS");
        System.out.println("Throw either 'Rock', 'Paper', or 'Scissors' and see if you can beat the dealer!");

    }

 //   public String throwDealerHand

    @Override
    public boolean winCheck() {
        return true;
    }

    @Override
    public void quitAsk() {
        if (winCheck() == true){
            System.out.println("You have won $" + bet + "!");
        }
        else {
            System.out.println("Sorry, no win this time.");
        }

        String userAnswer = console.getStringInput("Would you like to play again? Press 'y' to play again. Press 'n' to quit the game.");

        if (userAnswer.equals("y")){
            playing = true;
        }
        else {
            playing = false;
        }

        CasinoAccount.setBalance(player.getBalance());

    }

    public String getWinningMove(String handSign) {
        if (handSign == ROCK){
            return PAPER;
        }
        else if (handSign == PAPER){
            return SCISSOR;
        }
        else return ROCK;
    }


    public String getWinner(String handSignOfPlayer1, String handSignOfPlayer2) {
        if (getWinningMove(handSignOfPlayer1) == handSignOfPlayer2){
            return handSignOfPlayer2;
        }
        else{
            return handSignOfPlayer1;
        }
    }

    @Override
    public int playerBet() {
        System.out.println("Your current balance is: " + player.getBalance());
        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        bet = temp;
        return temp;
    }

    @Override
    public int calculateWinnings() {
        if (winCheck() == true){
            return (bet * 2);
        }
        else {
            return (bet * -1);
        }
    }

    @Override
    public void updateBalance() {
        bet = calculateWinnings();
        int newBalance = player.getBalance() + bet;
        player.setBalance(newBalance);
    }

    @Override
    public int calculateWinner() {
        return 0;
    }
}
