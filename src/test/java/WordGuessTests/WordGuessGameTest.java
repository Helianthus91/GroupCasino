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
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] charArray = new char[]{'b','o','b'};
        int expected = 3;

        //when
        int actual = wordGuessGame.getAmountOfGuesses(charArray);

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    void getCurrentGuessArray() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] expected = new char[3];


        //when
        char[] actual = wordGuessGame.getCurrentGuessArray(expected);

        //then
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    void getUserGuess() {
    }
}