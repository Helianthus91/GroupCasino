package com.github.zipcodewilmington.CrapsTests;

import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsGame;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CrapsGameTest {
    private CrapsGame crapsGame;

    @Before
    public void setCrapsGame() {
        crapsGame = new CrapsGame();
    }

    @After
    public void quitCrapsGame() {
        crapsGame = null;
    }

    @Test
    public void testRollDice() {
        int diceResult = crapsGame.rollDice();
        assertEquals(true, diceResult >= 1 && diceResult<= 6);
    }

    @Test
    public void testWinWithFirstRoll() {
        // given
        mockUserInput("1\n", "1\n", "N/n");
        // when
        String result = crapsGame.playGame();
        // then
        assertEquals("Congratulations, you win!", result);
    }

    @Test
    public void testLoseWithFirstRoll() {
        // given
        mockUserInput("1/n", "1\n", "N/n");
        // when
        String result = crapsGame.playGame();
        // then
        assertEquals("Sorry, you lose!", result);
    }

    @Test
    public void testPointNumberWin() {
        // given
        mockUserInput("4\n", "1\n", "N/n");
        // when
        String result = crapsGame.playGame();
        // then
        assertEquals("Congratulations, you win!", result);
    }

    @Test
    public void testPointNumberLose() {
        // given
        mockUserInput("4\n", "3\n", "N/n");
        // when
        String result = crapsGame.playGame();
        // then
        assertEquals("Sorry, you lose!", result);
    }

    @Test
    public void testPlayAgain() {
        // given
        mockUserInput("1\n", "2\n", "N\n");
        // when
        String result = crapsGame.playGame();
        // then
        assertEquals("Thank you for playing the game of Craps!", result);
    }

    @Test
    private void mockUserInput(String s, String s1, String s2) {
    }
}

