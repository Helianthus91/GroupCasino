package WordGuessTests;

import com.github.zipcodewilmington.casino.games.casualGames.wordGuess.WordGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class WordGuessGameTests {



    @Test
    public void getAmountOfGuessesTest(){
        //Given
        WordGuessGame wordGuess = new WordGuessGame();
        Integer expected = 6;
        String wordToGuess = "Banana";

        //When
        Integer actual = wordGuess.getAmountOfGuesses(wordToGuess);

        //Then
        Assert.assertEquals(expected, actual);
    }

    public void setWordTest(){
        //given
        WordGuessGame wordGuess = new WordGuessGame();
        char[] expected = new char[]{'p','u','r','p','l','e'};
        String wordString = "purple";

        //when
        wordGuess.setWord(purple);
        char[] actual = wordGuess.getWord();

        //then
        Assert.assertEquals(expected, actual);
    }



}
