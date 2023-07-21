package com.github.zipcodewilmington.CrapsTests;
import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsPlayer;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class CrapsPlayerTest {
    private CrapsPlayer player;

//    @Test
//    public void testPlaceBet() {
//        player.playerBet(100);
//        assertEquals(900, player.getBalance());
//    }
//
//    @Test
//    public void testWinBet() {
//        player.winBet();
//        assertEquals(1050, player.getBalance());
//    }
//
//    @Test
//    public void testLoseBet() {
//        player.loseBet();
//        assertEquals(975, player.getBalance());
//    }

    @Test
    public void testGetBalance() {
        int balance = player.getBalance();
        assertEquals(1000, balance);
    }
}



