package hexlet.code;

import hexlet.code.games.*;
import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int COUNT_TO_WIN = 3;
    private static final String GAME1 = "1 - Greet";
    private static final String GAME2 = "2 - Even";
    private static final String GAME3 = "3 - Calc";
    private static final String GAME4 = "4 - GCD";
    private static final String GAME5 = "5 - Progression";
    private static final String GAME6 = "6 - Prime";
    private static final String GAME0 = "0 - Exit";
    private static final String EVEN_TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String CALC_TASK = "What is the result of the expression?";
    private static final String NOD_TASK = "Find the greatest common divisor of given numbers.";
    private static final String PROGRESSION_TASK = "What number is missing in the progression?";
    private static final String PRIME_TASK = "Answer 'yes' if given number is prime, otherwise answer 'no'.";

    private static String playerName;
    private static int gameType;
    private static int countCorrect;
    private static String winMessage;
    private static String gameTask;

    private Engine() {

    }
    public static Random getRandom() {
        return RANDOM;
    }
    public static Scanner getScanner() {
        return SCANNER;
    }

    public static void setPlayerName(String playerName) {
        Engine.playerName = playerName;
    }
    public static void setGameType() {
        System.out.println("Please enter the game number and press Enter."
                + "\n" + Engine.GAME1
                + "\n" + Engine.GAME2
                + "\n" + Engine.GAME3
                + "\n" + Engine.GAME4
                + "\n" + Engine.GAME5
                + "\n" + Engine.GAME6
                + "\n" + Engine.GAME0);
        System.out.print("Your choice: ");
        gameType = SCANNER.nextInt();
    }
    public static void setGameTask() {
        gameTask = switch (gameType) {
            case 2 -> EVEN_TASK;
            case 3 -> CALC_TASK;
            case 4 -> NOD_TASK;
            case 5 -> PROGRESSION_TASK;
            case 6 -> PRIME_TASK;
            default -> "";
        };
    }
    public static void setCountCorrect() {
        Engine.countCorrect++;
    }
    public static void setCountCorrect(int exitNumber) {
        Engine.countCorrect = exitNumber;
    }
    public static void setWinMessage(String playerName) {
        Engine.winMessage = "Congratulations, " + playerName + "!";
    }

    public static void greetingPlayer() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = SCANNER.next();
        setPlayerName(playerName);
        setWinMessage(playerName);

        System.out.println("Hello, " + Engine.playerName + "!");
    }
    public static boolean isCorrect(String playerGuess, String correctAnswer) {
        return playerGuess.equals(correctAnswer);
    }
    public static void playGame() {
        switch (gameType) {
            case 1 -> greetingPlayer();
            case 2 -> manageGame(EvenGame::play);
            case 3 -> manageGame(CalcGame::play);
            case 4 -> manageGame(GcdGame::play);
            case 5 -> manageGame(ProgressionGame::play);
            case 6 -> manageGame(PrimeGame::play);
            case 0 -> System.exit(0);
            default -> System.out.println("Wrong game number. Choose between 0 to 6.");
        }

    }
    public static void printQuestion(String quest) {
        System.out.println(gameTask);
        System.out.println("Question: " + quest);
        System.out.print("Your answer: ");
    }
    public static void printResult(boolean res, String guess, String ans) {
        if (res) {
            System.out.println("Correct!");
            Engine.setCountCorrect();
        } else {
            System.out.println("'" + guess + "'" + " is wrong answer ;(. Correct answer was "
                    + "'" + ans + "'" + ".");
            System.out.println("Let's try again, " + playerName + "!");
            Engine.setCountCorrect(COUNT_TO_WIN + 1);
        }
    }
    public static void manageGame(Runnable game) {
        greetingPlayer();
        while (countCorrect < COUNT_TO_WIN) {
            game.run();
        }
        if (countCorrect == COUNT_TO_WIN) {
            System.out.println(winMessage);
        }
    }
}
