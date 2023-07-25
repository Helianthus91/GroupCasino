package com.github.zipcodewilmington.rockpaperscissorstest;

import com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors.RockPaperScissorsPlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.RockPaperScissors.RockPaperScissorsGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class RockPaperScissorsGameTest {
    @Test
    public void dealerThrowTest1(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        String[] test = new String[] {"rock", "paper", "scissor"};
        boolean expected = true;

        // When
        boolean actual = Arrays.asList(test).contains(game.dealerThrow());

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealerThrowTestFalse(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        String[] test = new String[] {"rock", "paper", "scissor"};
        boolean expected = false;

        // When
        boolean actual = Arrays.asList(test).contains("spock");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateWinningsTest1(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        int expected = 8;

        // When
        int actual = game.calculateWinnings(4, true);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calculateWinningsTest2(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        int expected = 200;

        // When
        int actual = game.calculateWinnings(100, true);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void calculateWinningsTestLoss(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        int expected = -4;

        // When
        int actual = game.calculateWinnings(4, false);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void isTieTwoRocks(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        boolean expected = true;

        // When
        boolean actual = game.isTie("rock", "rock");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTieTwoPapers(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        boolean expected = true;

        // When
        boolean actual = game.isTie("paper", "paper");

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isTieRockScissor(){
        // Given
        RockPaperScissorsGame game = new RockPaperScissorsGame();
        boolean expected = false;

        // When
        boolean actual = game.isTie("rock", "scissor");

        // Then
        Assert.assertEquals(expected, actual);
    }

}
