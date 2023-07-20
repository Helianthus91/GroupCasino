package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements GameInterface {
    public List<PlayerInterface> players;
    protected IOConsole console = new IOConsole(AnsiColor.PURPLE);


    public Game(List<PlayerInterface> players) {
        this.players = players;
    }

    public Game() {
        this(new ArrayList<>());
    }
    public Game(List<PlayerInterface> players, IOConsole console){
        this.players = players;
        this.console = new IOConsole(AnsiColor.PURPLE);
    }

    public List<PlayerInterface> getPlayers(){
        return players;
    }
}
