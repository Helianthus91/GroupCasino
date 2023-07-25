package com.github.zipcodewilmington.rockpaperscissorstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors.RockPaperScissorsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class RockPaperScissorsPlayerTest {
    @Test
    public void setBalanceTest(){
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
    public void getBalanceTest(){
        // Given
        int expected = 1000;

        // When
        RockPaperScissorsPlayer player = new RockPaperScissorsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
