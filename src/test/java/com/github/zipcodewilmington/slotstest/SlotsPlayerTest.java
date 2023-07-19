package com.github.zipcodewilmington.slotstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class SlotsPlayerTest {

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

    @Test
    public void getBetTest(){
        // Given
        int expected = 5;

        // When
        SlotsPlayer player = new SlotsPlayer();
        player.setBet(5);

        int actual = player.getBet();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBetTest(){
        // Given
        int expected = 5;

        // When
        SlotsPlayer player = new SlotsPlayer();
        player.setBet(5);

        int actual = player.getBet();

        // Then
        Assert.assertEquals(expected, actual);
    }
}
