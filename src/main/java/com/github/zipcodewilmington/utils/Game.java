package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public abstract class Game implements GameInterface {
    public List<PlayerInterface> players;


    public Game(List<PlayerInterface> players) {
        this.players = players;
    }

    public Game() {
        this(new ArrayList<>());
    }

    public List<PlayerInterface> getPlayers(){
        return players;
    }
}
