package com.github.zipcodewilmington.slotstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SlotsGameTest {

    @Test
    public void addTest(){
        // Given
        SlotsGame game = new SlotsGame();
        SlotsPlayer player = new SlotsPlayer();

        // When
        game.add(player);
        SlotsPlayer gamePlayer = game.getPlayer();

        // Then

        Assert.assertEquals(player, gamePlayer);
    }

    @Test
    public void removeTest(){
        // Given

        // When

        // Then
    }



    @Test
    public void slotTurnTest1(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] slotOptions = new String[]{"***", "~~~", "###", "ooo", "+++"};

        // When
        String slotResult = game.slotTurn();
        Boolean actual = Arrays.asList(slotOptions).contains(slotResult);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void slotTurnTest2(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] slotOptions = new String[]{"***", "~~~", "###", "ooo", "+++"};

        // When
        String slotResult = game.slotTurn();
        Boolean actual = Arrays.asList(slotOptions).contains(slotResult);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void slotTurnTestFalse(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] slotOptions = new String[]{"***", "~~~", "###", "ooo", "+++"};

        // When
        String slotResult = "9";
        Boolean actual = Arrays.asList(slotOptions).contains(slotResult);

        // Then
        Assert.assertFalse(actual);
    }

    @Test
    public void allOnesIsAWin(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] test = new String[] {"1", "1", "1"};
        boolean expected = true;

        // When
        boolean actual = game.winCheck(test);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void twoOnesIsALoss(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] test = new String[] {"1", "1", "3"};
        boolean expected = false;

        // When
        boolean actual = game.winCheck(test);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void allDiffIsALoss(){
        // Given
        SlotsGame game = new SlotsGame();
        String[] test = new String[] {"*", "+", "~"};
        boolean expected = false;

        // When
        boolean actual = game.winCheck(test);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateWinningsTest1(){
        // Given
        SlotsGame game = new SlotsGame();
        int expected = 40;

        // When
        int actual = game.calculateWinnings(4, true);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calculateWinningsTest2(){
        // Given
        SlotsGame game = new SlotsGame();
        int expected = 100;

        // When
        int actual = game.calculateWinnings(10, true);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calculateWinningsTestLoss(){
        // Given
        SlotsGame game = new SlotsGame();
        int expected = -4;

        // When
        int actual = game.calculateWinnings(4, false);

        // Then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void updateBalanceTest(){
        // Given

        // When

        // Then
    }



}
