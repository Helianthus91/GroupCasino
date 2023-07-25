package com.github.zipcodewilmington.roulettetests;

import com.github.zipcodewilmington.casino.games.gamblingGames.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.assertEquals;
public class RouletteGameTest {
    @Test
    public void testBet1() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 50;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 50 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 50 DOLLARS"
        // Expected balance after winning: 1050 or 950
    }
    @Test
    public void testBet2() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 25;
        //When
        // Assume the random spin number is odd and the prediction is "even"
        game.evaluateResult("even");
        // When
        // Expected output: "SORRY MAYBE NEXT TIME! YOU LOST 25 DOLLARS" or "GREAT GUESS! YOU WON 25 DOLLARS!"
        // Expected balance after losing: 975 or 1025
    }
    //
    @Test
    public void testBet3() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 525;
        //When
        // Assume the random spin number is odd and the prediction is "even"
        game.evaluateResult("even");
        // When
        // Expected output: "SORRY MAYBE NEXT TIME! YOU LOST 525 DOLLARS" or "GREAT GUESS! YOU WON 525 DOLLARS!"
        // Expected balance after losing: 475 or 1525
    }
    @Test
    public void testBet4() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 203;
        // When
        game.evaluateResult("odd");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 203 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 203 DOLLARS"
        // Expected balance after winning: 1203 or 797
    }
    @Test
    public void testBet5() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 700;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 700 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 700 DOLLARS"
        // Expected balance after winning: 1700 or 300
    }
    @Test
    public void testBet6() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 1000;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 1000 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 1000 DOLLARS"
        // Expected balance after winning: 2000 or 0
    }
    @Test
    public void testBet7() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 1;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 1 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 1 DOLLARS"
        // Expected balance after winning: 999 or 1001
    }
    @Test
    public void testBet8() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 200;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 200 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 200 DOLLARS"
        // Expected balance after winning: 1200 or 800
    }
    @Test
    public void testBet9() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance = 1000;
        game.betAmount = 400;
        // When
        game.evaluateResult("even");
        // Then
        // Expected output: "GREAT GUESS! YOU WON 400 DOLLARS!" or "SORRY MAYBE NEXT TIME! YOU LOST 400 DOLLARS"
        // Expected balance after winning: 1400 or 600
    }
}
    /*@Test
    // Test case: Betting an amount greater than the balance
    public void testBettingAmountGreaterThanBalance() {
        RouletteGame game = new RouletteGame();
        //Given
        game.balance = 500;
        //When
        game.evaluateResult("Relax, YOU DON'T HAVE ENOUGH MONEY! HIT THE ATM ASAP!");
        ;
        //Then
    }
    @Test
    // Test case: Betting 0 to quit the game
    public void testBettingZeroToQuit() {
        RouletteGame game = new RouletteGame();
        // Given
        game.balance=100;
        game.betAmount = 0;
        // When
        game.evaluateResult("THANK YOU FOR PLAYING! SPEND ALL YOUR MONEY!!!!");
        // Then
    }*/





