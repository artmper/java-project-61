package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.EvenGame;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    private static final String game1 = "1 - Greet";
    private static final String game2 = "2 - Even";
    private static final String game3 = "3 - Calc";
    private static final String game0 = "0 - Exit";


    private static String playerName;
    private static int gameType;
    private static int countCorrect;
    private static String winMessage;

    public static String getPlayerName() {
        return playerName;
    }
    public static void setPlayerName(String playerName) {
        Engine.playerName = playerName;
    }
    public static void setGameType() {
        System.out.println("Please enter the game number and press Enter."
                + "\n" + Engine.game1
                + "\n" + Engine.game2
                + "\n" + Engine.game3
                + "\n" + Engine.game0);
        System.out.print("Your choice: ");
        gameType = scanner.nextInt();
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
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = scanner.next();
        setPlayerName(playerName);
        setWinMessage(playerName);

        System.out.println("Hello, " + Engine.getPlayerName() + "!");
    }

    public static void playGame() {
        String evenTask = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String calcTask = "What is the result of the expression?";

        switch (gameType) {
            case 1:
                greetingPlayer();
                break;
            case 2:
                greetingPlayer();
                System.out.println(evenTask);
                while (countCorrect < 3) {
                    EvenGame.playEven();
                }
                if (countCorrect < 4) {
                    System.out.println(winMessage);
                }
                break;
            case 3:
                greetingPlayer();
                System.out.println(calcTask);
                while (countCorrect < 3) {
                    CalcGame.playCalc();
                }
                if (countCorrect < 4) {
                    System.out.println(winMessage);
                }
                break;
            case 0:
            default:
                break;
        }
    }
}
