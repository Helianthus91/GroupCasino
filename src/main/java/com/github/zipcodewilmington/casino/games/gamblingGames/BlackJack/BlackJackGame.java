package com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack;

import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.Deck;

import java.util.ArrayList;
import java.util.List;

public class BlackJackGame extends GamblingGame {
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private List<Deck> deckOfCards;
    private int bet;
    private int winnings;

    private int playerChoice;

    public static void main(String[] args) {
        new BlackJackGame().run();
    }
    @Override
    public void run() {
        //Welcome to blackjack
        intro();
        add();
        addDealer();
        Deck deckOfCards = new Deck();
        //Get bets
        playerBet();

        //Dealer player and dealer hands
        player.setStartingHand(deckOfCards);
        System.out.println(player.getHand().toString());
        System.out.println(player.calculateHand()); //Change to dealing hand
        dealer.setStartingHand(deckOfCards);

        //Ask player options (hit, stay) if not 21.


        //hit give player a card
        while (player.calculateHand() < 21){
        playerChoice = playerBetOption();
        switch(playerChoice) {

            case 1:
                player.hit(deckOfCards.drawCard());
                System.out.println(player.getHand().toString());
                System.out.println(player.calculateHand());

            case 2:
                break;
        }}
        checkBust();
        busted();
        //check total in between. If player goes over 21, bust and lose.
        //stay switch to dealer who will go automatically
        //Dealer plays until 17.
        //Same lose condition for dealer.
        //After player and dealer go, compare scored to check winner.







    }

    @Override
    public void intro() {
        System.out.println("Welcome to the BlackJack" + "\n");
        System.out.println("Place your bet at the table to begin");

    }

    public void add(){
        this.player = new BlackJackPlayer();

    }
    public void addDealer(){
        this.dealer = new BlackJackPlayer();

    }

    @Override
    public boolean winCheck() {
        return false;
    }

    @Override
    public void quitAsk() {

    }
    public void checkBust(){
        if (player.calculateHand() > 21){
            System.out.println("Busted");
            busted();
        }
    }
    public void busted(){
        System.out.println("You have gone over 21 and Busted. \n " +
                "You lose.");
    }

    @Override
    public void playerBet(){
        System.out.println("Your current balance is: " + player.getBalance());
        int temp = console.getIntegerInput("Please enter how much you would like to bet: ");

        bet = temp;
    }

    public Integer playerBetOption(){
        return console.getIntegerInput("What would you like to do? \n 1: Hit \n 2: Stay");
    }

    @Override
    public int calculateWinnings() {
        return 0;
    }

    @Override
    public int calculateWinner() {
        return 2;
    }

    @Override
    public void updateBalance() {

    }

}
