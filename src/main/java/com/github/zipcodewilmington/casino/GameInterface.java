package com.github.zipcodewilmington.casino;

import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    public List<PlayerInterface> getPlayers();
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    default void add(PlayerInterface player){
        getPlayers().add(player);
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    default void remove(PlayerInterface player){
        getPlayers().remove(player);
    }

    /**
     * specifies how the game will run
     */
    void run();

     void intro();

     boolean winCheck();

     void quitAsk();

}
