package com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Objects;
import java.util.Random;

public class RockPaperScissorsGame extends GamblingGame {
    protected static final String ROCK = "rock";
    protected static final String PAPER = "paper";
    protected static final String SCISSOR = "scissor";

    public RockPaperScissorsPlayer player;

    public RockPaperScissorsPlayer dealer = new RockPaperScissorsPlayer();

    private String dealerThrow;
    private String playerThrow;

    private int bet;

    private IOConsole console = new IOConsole();

    private boolean wonGame;

    private boolean playing = true;


    public void add(){
        this.player = new RockPaperScissorsPlayer();
    }

    public void remove(RockPaperScissorsPlayer player){
        this.player = null;
    }

    public RockPaperScissorsPlayer getPlayer(){
        return player;
    }


    public void run() {
        add();
        intro();
        while (playing == true) {
            System.out.println("Your current balance is: " + player.getBalance());

            // Get player bet
            bet = playerBet();

            // Get user throw
            playerThrow = userThrow();
            dealerThrow = dealerThrow();
            System.out.println("The dealer threw: " + dealerThrow);

            if (isTie(playerThrow, dealerThrow)){

            }
            else {
                wonGame = winCheck();
                // Update bet based on result of spin
                bet = calculateWinnings(bet, wonGame);
                // Update player balance with new bet
                updateBalance();
            }
            quitAsk();
        }

    }

    @Override
    public void intro() {

        System.out.println("Welcome to ROCK PAPER SCISSORS");
        System.out.println("Throw either 'Rock', 'Paper', or 'Scissors' and see if you can beat the dealer!");

    }

    public String userThrow(){
        String user = console.getStringInput("Enter 'rock', 'paper', or 'scissor'");

        return user;
    }


    public String dealerThrow(){
        Random rand = new Random();
        int numThrow = rand.nextInt(3);

        if (numThrow == 0){
            return ROCK;
        }
        else if (numThrow == 1){
            return PAPER;
        }
        else {
            return SCISSOR;
        }
    }

    @Override
    public boolean winCheck() {
        if (getWinner(playerThrow, dealerThrow) == player){
            return true;
        }
        return false;
    }



    @Override
    public void quitAsk() {
        if (isTie(playerThrow, dealerThrow)){
            System.out.println("It's a tie! No one loses");
        }
        else if (wonGame == true){
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
        if (Objects.equals(handSign, ROCK)){
            return PAPER;
        }
        else if (Objects.equals(handSign, PAPER)){
            return SCISSOR;
        }
        else return ROCK;
    }

    public boolean isTie(String handSignOfPlayer, String handSignOfDealer){
        if (handSignOfPlayer.equals(handSignOfDealer)){
            return true;
        }
        return false;
    }

    public RockPaperScissorsPlayer getWinner(String handSignOfPlayer, String handSignOfDealer) {
        if (getWinningMove(handSignOfPlayer).equals(handSignOfDealer)){
            return dealer;
        }
        else{
            return player;
        }
    }

    @Override
    public int playerBet() {
        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        return temp;
    }

    public int calculateWinnings(int bet, boolean wonGame) {
        if (wonGame){
            return (bet * 2);
        }
        else {
            return (bet * -1);
        }
    }

    @Override
    public void updateBalance() {
        int newBalance = player.getBalance() + bet;
        player.setBalance(newBalance);
    }

    @Override
    public int calculateWinner() {
        return 0;
    }

    @Override
    public int calculateWinnings(){
        return 0;
    }
}
