package com.github.zipcodewilmington.casino.games.gamblingGames;

import com.github.zipcodewilmington.utils.Game;

public abstract class GamblingGame extends Game implements GamblingGameInterface{
    public abstract int calculateWinnings();

    public abstract int calculateWinner();
}
