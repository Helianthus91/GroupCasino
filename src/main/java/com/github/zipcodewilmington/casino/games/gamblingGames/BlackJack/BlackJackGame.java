package com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.gamblingGames.GamblingGame;
import com.github.zipcodewilmington.utils.Deck;

import java.util.List;

public class BlackJackGame extends GamblingGame {
    private BlackJackPlayer player;
    private BlackJackPlayer dealer;
    private List<Deck> deckOfCards;
    private int bet;
    private int winnings;
    private String winner;
    private boolean playing = true;

    private int playerChoice;

    public static void main(String[] args) {
        new BlackJackGame().run();
    }
    @Override
    public void run() {
        //Welcome to blackjack
        intro();
        while(playing){
        add();
        addDealer();
        Deck deckOfCards = new Deck();
        //Get bets
        bet = playerBet();

        //Dealer player and dealer hands
        player.setStartingHand(deckOfCards);
        System.out.println("Player Hand \n" + player.getHand().toString());
        System.out.println(player.calculateHand() + "\n"); //Change to dealing hand

        dealer.setStartingHand(deckOfCards);
        System.out.println("Dealer Hand \n" + dealer.getHand().toString() + "\n");

        //Ask player options (hit, stay) if not 21.

        boolean playerTurn = true;

        //hit give player a card
        while (player.calculateHand() < 21 && playerTurn) {

            playerChoice = playerBetOption();
            if (playerChoice == 1) {
                player.hit(deckOfCards.drawCard());
                System.out.println("\n" + player.getHand().toString());
                System.out.println(player.calculateHand());
            } else if (playerChoice == 2) {
                playerTurn = false;
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
        checkBust();

        while (dealer.calculateHand() < 17 && player.calculateHand() < 21) {
            dealer.hit(deckOfCards.drawCard());
            System.out.println(dealer.getHand().toString());
            System.out.println(dealer.calculateHand());
            checkDealerBust();
        }

        winner = checkWinner();
//        bet = calculateWinnings();
        updateBalance();
        quitAsk();
    }
    }
//        if (dealer.calculateHand() > 17 && p)

        //check total in between. If player goes over 21, bust and lose.
        //stay switch to dealer who will go automatically
        //Dealer plays until 17.
        //Same lose condition for dealer.
        //After player and dealer go, compare scored to check winner.





        public String checkWinner(){
        String winner = "dealer";
            if (player.calculateHand() < 22 && player.calculateHand() > dealer.calculateHand() ){
                winner = "player";
            }
            if (dealer.calculateHand() > 21){
                winner = "player";
            }

            return winner;
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


    public void checkBust(){
        if (player.calculateHand() > 21){
            System.out.println("Player Busted");
            busted();
        } }

        public void checkDealerBust(){
            if (dealer.calculateHand() > 21){
                System.out.println("Player Busted");
                dealerBusted();
            }
    }
    public void busted(){
        System.out.println("You have gone over 21 and Busted. \n " +
                "You lose.");
    }
    public void dealerBusted(){
        System.out.println("Dealer has gone over 21 and Busted. \n " +
                "You win!" +
                ".");
    }

    @Override
    public int playerBet(){
        System.out.println("Your current balance is: " + player.getBalance());
        int temp = console.getIntegerInput("\n Please enter how much you would like to bet: ");

        return temp;
    }
    @Override
    public void quitAsk(){
        if (winner.equals("player")){
            System.out.println("\nYou have won $" + bet + "!");
        }
        else {
            System.out.println("\nSorry, no win this time.");
        }

        String userAnswer = console.getStringInput("\nWould you like us to deal again? \nPress 'y' to play again. Press 'n' to quit the game.");

        if (userAnswer.equals("y")){
            playing = true;
        }
        else {
            playing = false;
        }

        CasinoAccount.setBalance(player.getBalance());
        String accountName = player.getArcadeAccount().getName();
        String accountPassword = player.getArcadeAccount().getPassword();
        Integer accountBalance = player.getBalance();
        updateSelectedAccount(accountName, accountPassword, accountBalance);

    }

    public Integer playerBetOption(){
        return console.getIntegerInput("What would you like to do? \n 1: Hit \n 2: Stay");
    }

    @Override
    public int calculateWinnings() {
        if (winner.equals("player")){
            return (bet * 2);
        }
        else {
            return (bet * -1);
        }
    }

    @Override
    public int calculateWinner() {
        return 2;
    }

    @Override
    public void updateBalance() {
        bet = calculateWinnings();
        int newBalance = player.getBalance() + bet;
        player.setBalance(newBalance);

    }
}
