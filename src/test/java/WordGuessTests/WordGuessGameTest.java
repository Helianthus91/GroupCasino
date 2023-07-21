package WordGuessTests;

import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordGuessGameTest {

    @Test
    void getRandomWord() {


    }

    @Test
    void setTheWord() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] expected = new char[]{'b','o','b'};
        String pickedWord = "bob";
        //when
        char[] actual = wordGuessGame.setTheWord(pickedWord);
        //then
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    void getAmountOfGuesses() {
    }

    @Test
    void getCurrentGuessArray() {
    }

    @Test
    void getUserGuess() {
    }
}