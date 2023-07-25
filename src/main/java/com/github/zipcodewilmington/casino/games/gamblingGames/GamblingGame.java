package com.github.zipcodewilmington.casino.games.gamblingGames;

import com.github.zipcodewilmington.utils.Game;

public abstract class GamblingGame extends Game implements GamblingGameInterface{
    public abstract int calculateWinnings(Integer bet, Boolean wonGame);

    public abstract int calculateWinner();


}
