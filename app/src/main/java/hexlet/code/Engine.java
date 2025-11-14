package hexlet.code;

import hexlet.code.games.EvenGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    private static final Random RANDOM = new Random();
    private static final Scanner SCANNER = new Scanner(System.in);

    private static final int COUNT_TO_WIN = 3;
    private static final int MIN_PRIME = 2;
    private static final String GAME1 = "1 - Greet";
    private static final String GAME2 = "2 - Even";
    private static final String GAME3 = "3 - Calc";
    private static final String GAME4 = "4 - GCD";
    private static final String GAME5 = "5 - Progression";
    private static final String GAME6 = "6 - Prime";
    private static final String GAME0 = "0 - Exit";

    private static int countCorrect;
    private static String playerName;
    private static String gameType;
    private static String[] gameResult;

    public static Random getRandom() {
        return RANDOM;
    }

    public static String getGameType() {
        return gameType;
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
        gameType = SCANNER.nextLine();
    }

    public static void setGameResult() {
        gameResult = switch (gameType) {
            case "2" -> EvenGame.getGame();
            case "3" -> CalcGame.getGame();
            case "4" -> GcdGame.getGame();
            case "5" -> ProgressionGame.getGame();
            case "6" -> PrimeGame.getGame();
            default -> new String[]{};
        };
    }

    public static void greetingPlayer() {
        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = SCANNER.next();
        System.out.println("Hello, " + playerName + "!");
    }
    public static boolean isCorrect(String playerGuess, String correctAnswer) {
        return playerGuess.equals(correctAnswer);
    }
    public static boolean isPrime(int number) {
        if (number == MIN_PRIME) {
            return true;
        }
        if (number < MIN_PRIME || number % 2 == 0) {
            return false;
        }
        for (int i = MIN_PRIME + 1; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printQuestion() {
        System.out.println(gameResult[0]);
        System.out.print("Your answer: ");
    }
    public static void printResult() {
        var guess = SCANNER.next();
        var answer = gameResult[1];
        if (isCorrect(guess, answer)) {
            System.out.println("Correct!");
            countCorrect++;
        } else {
            System.out.println("'" + guess + "'" + " is wrong answer ;(. Correct answer was "
                    + "'" + answer + "'" + ".");
            System.out.println("Let's try again, " + playerName + "!");
            countCorrect = COUNT_TO_WIN + 1;
        }
    }
    public static void manageGame() {
        greetingPlayer();
        System.out.println(gameResult[2]);

        while (countCorrect < COUNT_TO_WIN) {
            printQuestion();
            printResult();
            setGameResult();
        }
        if (countCorrect == COUNT_TO_WIN) {
            System.out.println("Congratulations, " + playerName + "!");
        }
        SCANNER.close();
    }
}
