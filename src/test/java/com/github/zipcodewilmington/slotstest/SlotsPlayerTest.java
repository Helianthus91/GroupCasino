package com.github.zipcodewilmington.slotstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

public class SlotsPlayerTest {

    @Test
    public void setBalanceTest1(){
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
    public void setBalanceTest2(){
        // Given
        int expected = 4;

        // When
        SlotsPlayer player = new SlotsPlayer();
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
        SlotsPlayer player = new SlotsPlayer();
        player.setBalance(1000);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalanceTest2(){
        // Given
        int expected = 575;

        // When
        SlotsPlayer player = new SlotsPlayer();
        player.setBalance(575);

        int actual = player.getBalance();

        // Then
        Assert.assertEquals(expected, actual);
    }


}
