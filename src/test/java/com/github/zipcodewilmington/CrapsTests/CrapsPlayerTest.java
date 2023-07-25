package com.github.zipcodewilmington.CrapsTests;

import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;


public class CrapsPlayerTest {

    @Test
    public void setBalanceTest(){
        // Given
        int expected = 1000;

        // When
        CrapsPlayer player = new CrapsPlayer();
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
        CrapsPlayer player = new CrapsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

}



