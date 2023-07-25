package com.github.zipcodewilmington.crapstests;

import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsPlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

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



