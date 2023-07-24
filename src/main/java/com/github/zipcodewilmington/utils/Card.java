package com.github.zipcodewilmington.utils;

public class Card {

        private Suit suit;
        private CardValueEnum cardValue;

        public Card (CardValueEnum cardValue, Suit suit)
        {
            this.cardValue = cardValue;
            this.suit = suit;
        }

        public Suit getSuit()
        {
            return suit;
        }

        public void setSuit(Suit suit)
        {
            this.suit = suit;
        }

        public CardValueEnum getCardValue()
        {
            return cardValue;
        }

        public void setCardValue(CardValueEnum cardValue)
        {
            this.cardValue = cardValue;
        }

    @Override
    public String toString() {
        return "Card { " + cardValue + " of " + suit + " }";
    }
}




