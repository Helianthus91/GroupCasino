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


        //Method for printing the contents of shuffled deck for debugging
//        for (Object o : deck) {
//            Card aCard = (Card) o;
//            System.out.println(aCard.getCardValue() + " of " + aCard.getSuit());
//        }
    }

    public Card drawCard(){
        Card topCard = (Card) deck.get(0);
        deck.remove(deck.get(0));
        return topCard;
    }


}