package BlackJackTests;

import com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.Deck;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayerTests {


    @Test


    public void setStartingHandTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 2;
        //when
        player.setStartingHand(deck);
        int actual = player.getHand().size();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 100;
        //when
        player.setBalance(100);
        int actual = player.getBalance();

        //then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getBalanceTest2(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 10000;
        //when
        player.setBalance(10000);
        int actual = player.getBalance();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetAccountNameTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        String expected = "Bobster";
        //when
        player.setAccountName(expected);
        String actual = player.getAccountName();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GetAccountNameTest2(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        String expected = "The King";
        //when
        player.setAccountName(expected);
        String actual = player.getAccountName();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountPasswordTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        String expected = "Bobster";
        //when
        player.setAccountPassword("Bobster");
        String actual = player.getAccountPassword();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountPasswordTest2(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        String expected = "Password1";
        //when
        player.setAccountPassword(expected);
        String actual = player.getAccountPassword();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setHandTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 1;
        Card card = deck.drawCard();
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);

        //when
        player.setHand(cardList);
        int actual = player.getHand().size();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setHandTest2(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 2;
        Card card = deck.drawCard();
        Card card2 = deck.drawCard();
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);
        cardList.add(card2);

        //when
        player.setHand(cardList);
        int actual = player.getHand().size();

        //then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void hitTest(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 3;
        Card card = deck.drawCard();
        Card card2 = deck.drawCard();
        Card card3 = deck.drawCard();
        List<Card> cardList = new ArrayList<>();

        //when
        player.hit(card);
        player.hit(card2);
        player.hit(card3);
        int actual = player.getHand().size();

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hitTest2(){
        //given
        BlackJackPlayer player = new BlackJackPlayer();
        Deck deck = new Deck();
        int expected = 2;
        Card card = deck.drawCard();
        Card card2 = deck.drawCard();
        List<Card> cardList = new ArrayList<>();

        //when
        player.hit(card);
        player.hit(card2);
        int actual = player.getHand().size();

        //then
        Assert.assertEquals(expected, actual);
    }
}
