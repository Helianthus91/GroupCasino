package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessGame;
import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessPlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessGame;
import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessPlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.Craps.CrapsPlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.Roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.Roulette.RoulettePlayer;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.gamblingGames.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if ("SLOTS".equals(gameSelectionInput)) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if ("WordGuess".equalsIgnoreCase(gameSelectionInput)) {
                        play(new WordGuessGame(), new WordGuessPlayer());
                    } else if ("Roulette".equalsIgnoreCase(gameSelectionInput)) {
                        play(new RouletteGame(), new RoulettePlayer());
                    }else if ("Craps".equalsIgnoreCase(gameSelectionInput)) {
                        play(new CrapsGame(), new CrapsPlayer());
                    }else {
                        console.println("[ %s ] is an invalid game selection. Returning to main menu.", gameSelectionInput);
                    }
                } else {

                    console.println("No account found with name of [ %s ] and password of [ %s ]", accountName, accountPassword);
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ WordGuess ], [ Craps ], [ Roulette ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
