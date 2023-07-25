
package com.github.zipcodewilmington.CrapsTests;
import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CrapsGameTest {

    @Test
    public void calculateWinningsTest1() {
        // Given
        CrapsGame game = new CrapsGame();
        int expected = 8;

        // When
        int actual = game.calculateWinnings(4, true);

        // Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void calculateWinningsTest2(){
        // Given
        CrapsGame game = new CrapsGame();
        int expected = 20;

        // When
        int actual = game.calculateWinnings(10, true);

        // Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void calculateWinningsTest3(){
        // Given
        CrapsGame game = new CrapsGame();
        int expected = 100;

        // When
        int actual = game.calculateWinnings(50, true);

        // Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void calculateWinningsTestLoss(){
        // Given
        CrapsGame game = new CrapsGame();
        int expected = -4;

        // When
        int actual = game.calculateWinnings(4, false);

        // Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void calculateWinningsTestLoss2(){
        // Given
        CrapsGame game = new CrapsGame();
        int expected = -10;

        // When
        int actual = game.calculateWinnings(10, false);

        // Then
        Assert.assertEquals(expected, actual);

    }
    @Test

    public void calculateWinningsTestLoss3(){
        // Given
        CrapsGame game = new CrapsGame();
        int expected = -20;

        // When
        int actual = game.calculateWinnings(20, false);

        // Then
        Assert.assertEquals(expected, actual);

    }
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


