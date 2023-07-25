package com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.Deck;


import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements PlayerInterface {


    private  String accountName;
    private  String accountPassword;
    private int balance = 0;

    private List<Card> hand;

    private CasinoAccount arcadeAccount;


    public BlackJackPlayer(){
        this.balance = CasinoAccount.getBalance();
        this.accountName = CasinoAccount.getName();
        this.accountPassword = CasinoAccount.getPassword();
        this.hand = new ArrayList<>();


    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public List<Card> getHand() {
        return hand;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public void hit(Card card){
        this.hand.add(card);
    }

    public void setStartingHand(Deck deck){
        this.hand.add(deck.drawCard());
        this.hand.add(deck.drawCard());
    }

    public int calculateHand(){
        int totalHandValue = 0;
        for(Card card : this.hand){
            totalHandValue = totalHandValue + card.getCardValue().getCardValue();
        }
        return totalHandValue;
    }

    public CasinoAccount getArcadeAccount(){

        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

}