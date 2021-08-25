package Hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Hangman {

    public static final String[] WORDS = {
            "Tiffany", "Chucky", "Mark", "Charles", "Kitana",
            "Cassandra", "Sophitia", "Auriona", "Monique", "Dante",
            "Jeremiah", "Trey", "Mileena", "Mario", "Peach",
            "Daisy", "Luigi", "Yoshi", "Code", "Lyoko"
    };

    public static final Random RANDOM = new Random();
    public static final int MAX_ERRORS = 10;
    private String wordsToFind;
    private char[] wordsFounded;
    private int Errors;
    private ArrayList < String > letters = new ArrayList< >();

    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
    public void newGame() {
        Errors = 0;
        letters.clear();
        wordsToFind = nextWordToFind();
        wordsFounded = new char[wordsToFind.length()];

        for (int i = 0; i < wordsFounded.length; i++) {
            wordsFounded[i] = '_';
        }
    }

    public boolean wordFound() {
        return wordsToFind.contentEquals(new String(wordsFounded));
    }
    private void enter(String c) {
        if (!letters.contains(c)) {
            if (wordsToFind.contains(c)) {
                int index = wordsToFind.indexOf(c);
                while (index >= 0) {
                    wordsFounded[index] = c.charAt(0);
                    index = wordsToFind.indexOf(c, index + 1);
                }
            } else {
                Errors++;
            }
            letters.add(c);
        }
    }
    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < wordsFounded.length; i++) {
            builder.append(wordsFounded[i]);
            if (i < wordsFounded.length - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
    public void playGame() {
        try (Scanner input = new Scanner(System.in)) {
            while (Errors < MAX_ERRORS) {
                System.out.println("\nEnter a letter : ");
                String str = input.next();

                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }
                enter(str);
                System.out.println("\n" + wordFoundContent());
                if (wordFound()) {
                    System.out.println("\nSplendid! You Win");
                    break;
                } else {
                    System.out.println("\n=> No.of tries remaining : " + (MAX_ERRORS - Errors));
                }
            }
            if (Errors == MAX_ERRORS) {
                System.out.println("\nI'm sorry, You was so close");
                System.out.println("=> Word to find was : " + wordsToFind);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(" Welcome to my hangman Game!! Have Fun");
        System.out.println(" ");
        System.out.println("Please try your best and Don't Over think it");
        Hangman hangmanGame = new Hangman();
        hangmanGame.newGame();
        hangmanGame.playGame();
    }

}