package com.github.zipcodewilmington.casino.games.casualGames.wordGuess;

import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordGuessGame extends CasualGame {
    private String word;

    private char[] correctWord;
    private char[] currentGuess;
    private int amountOfGuesses;
    private boolean game;
    private char guess;
    boolean repeatGame;

    public static void main(String[] args) {
        new WordGuessGame().run();
    }

    @Override
    public void run() {
        repeatGame = true;
        while (repeatGame){

        game = true;
        intro();
        word = getRandomWord();
        setWord(word);
        System.out.println(correctWord);
        setEmptyArray();

        while(game) {
            printOutTheGuess();
            guess = getUserGuess();
            if (guess == '-'){game = false; repeatGame = false; break; }
            checkGuess();

            String checker = String.valueOf(guess);
            if (!Arrays.toString(correctWord).contains(checker)) {
                incrementRemainingGuesses();
            }

            if(Arrays.toString(correctWord).equals(Arrays.toString(currentGuess))){
                System.out.format("You have guessed the correct word! %s", Arrays.toString(correctWord));
                System.out.println("Goodbye player!");
                game = false;
                quitAsk();
            }

            if (amountOfGuesses == 0 && !Arrays.toString(correctWord).equals(Arrays.toString(currentGuess))){
                System.out.println("Out of guesses. You lose.");
                System.out.printf("The word was %s", Arrays.toString(correctWord));
                System.out.println("\n" + "Please try again");
                game = false;
                quitAsk();
            }



        }}



    }

    @Override
    public void intro() {
        console.println("Welcome to the Word Guess Game!");
        console.println("No money is on the line here.");
        console.println("We have a random word. You have as many chances to guess as there are letters in the word!" + "\n" +
                "lets begin...");

    }

    @Override
    public boolean winCheck() {
        return false;
    }

    @Override
    public void quitAsk() {
        char replayDecision = IOConsole.getCharInput("Would you like to play again? Enter 'N' to quit or any other input to continue");
        if (replayDecision == 'N'){
            repeatGame = false;
        }

    }
    public static String getRandomWord(){
        Random rand = new Random();
        ArrayList<String> words = new ArrayList<>();

        words.add("easy");
        words.add("thorough");
        words.add("penguin");
        words.add("puddle");
        words.add("heaven");
        words.add("zoology");
        words.add("spirit");
        words.add("balance");
        words.add("mundane");
        words.add("network");
        words.add("parallel");
        words.add("juice");
        words.add("application");
        words.add("calculator");

        int x = rand.nextInt(words.size() - 1);

        return words.get(x);
    }

    public void setWord(String word){
        correctWord = word.toCharArray();
        amountOfGuesses = correctWord.length;
        currentGuess = new char[correctWord.length];
    }

    public void setEmptyArray(){
        for (int i = 0; i < word.length(); i++){
            currentGuess[i] = '_';
        }
    }

    public void printOutTheGuess(){
        for (int i = 0; i < word.length(); i++) {
            if (i == word.length() - 1) {
                System.out.println(currentGuess[i]);
            } else {
                System.out.print(currentGuess[i] + " ");
            }
        }
        System.out.printf("You have %d guesses remaining.\n\n", amountOfGuesses);
    }

    public char getUserGuess(){
        // User Guess Input
        guess = IOConsole.getCharInput("Enter a single character (enter '-' to stop the current game):");


        return guess;
    }

    public void checkGuess(){
        for (int i = 0; i < word.length(); i++) {
            if (correctWord[i] == guess) {
                currentGuess[i] = guess;
            }
        }}

        public void incrementRemainingGuesses(){
            amountOfGuesses--;
        }


    }







