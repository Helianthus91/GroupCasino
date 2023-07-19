package com.github.zipcodewilmington.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Deck
{
    private ArrayList deck;

    public Deck ()
    {
        this.deck = new ArrayList();
        for (int i=0; i<13; i++)
        {
            CardValueEnum value = CardValueEnum.values()[i];

            for (int j=0; j<4; j++)
            {
                Card card = new Card(value, Suit.values()[j]);
                this.deck.add(card);
            }
        }

        Collections.shuffle(deck);

        for (Object o : deck) {
            Card aCard = (Card) o;
            System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
        }
    }

    static void run(){
        Deck deck = new Deck();
    }

    public static void main(String[] args) {
        Deck.run();
    }

}