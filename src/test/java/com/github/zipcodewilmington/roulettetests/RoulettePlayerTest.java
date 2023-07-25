package com.github.zipcodewilmington.roulettetests;

import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class RoulettePlayerTest {
    @Test
    public void setBalanceTest(){
        // Given
        int expected = 1000;

        // When
        SlotsPlayer player = new SlotsPlayer();
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
        SlotsPlayer player = new SlotsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
