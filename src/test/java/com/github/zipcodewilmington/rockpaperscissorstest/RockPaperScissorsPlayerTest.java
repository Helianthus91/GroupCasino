package com.github.zipcodewilmington.rockpaperscissorstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors.RockPaperScissorsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class RockPaperScissorsPlayerTest {
    @Test
    public void setBalanceTest1(){
        // Given
        int expected = 1000;

        // When
        RockPaperScissorsPlayer player = new RockPaperScissorsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalanceTest2(){
        // Given
        int expected = 4;

        // When
        RockPaperScissorsPlayer player = new RockPaperScissorsPlayer();
        player.setBalance(4);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest1(){
        // Given
        int expected = 1000;

        // When
        RockPaperScissorsPlayer player = new RockPaperScissorsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest2(){
        // Given
        int expected = 4;

        // When
        RockPaperScissorsPlayer player = new RockPaperScissorsPlayer();
        player.setBalance(4);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
