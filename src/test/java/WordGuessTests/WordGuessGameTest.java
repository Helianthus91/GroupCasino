package WordGuessTests;

import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordGuessGameTest {

    @Test
    void setTheWordTest() {
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
    void setTheWordTest2() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] expected = new char[]{'b','o','b','s','t','e','r'};
        String pickedWord = "bobster";
        //when
        char[] actual = wordGuessGame.setTheWord(pickedWord);
        //then
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    void getAmountOfGuessesTest() {
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
    void getAmountOfGuessesTest2() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] charArray = new char[]{'b','o','b','s','t','e','r'};
        int expected = 7;

        //when
        int actual = wordGuessGame.getAmountOfGuesses(charArray);

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    void getCurrentGuessArrayTest() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] expected = new char[3];


        //when
        char[] actual = wordGuessGame.getCurrentGuessArray(expected);

        //then
        Assert.assertArrayEquals(expected, actual);

    }
    @Test
    void getCurrentGuessArrayTest2() {
        //given
        WordGuessGame wordGuessGame = new WordGuessGame();
        char[] expected = new char[11];


        //when
        char[] actual = wordGuessGame.getCurrentGuessArray(expected);

        //then
        Assert.assertArrayEquals(expected, actual);

    }

}