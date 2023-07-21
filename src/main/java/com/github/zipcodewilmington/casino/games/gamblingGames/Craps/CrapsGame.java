package com.github.zipcodewilmington.casino.games.gamblingGames.Craps;

import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);
    public static int rollDice() {
        return random.nextInt(6) + 1;
    }


    public String playGame() {
        return null;
    }
}
