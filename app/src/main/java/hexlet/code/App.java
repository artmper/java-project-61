package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    private static final String GAME1 = "1 - Greet";
    private static final String GAME2 = "2 - Even";
    private static final String GAME3 = "3 - Calc";
    private static final String GAME4 = "4 - GCD";
    private static final String GAME5 = "5 - Progression";
    private static final String GAME6 = "6 - Prime";
    private static final String GAME0 = "0 - Exit";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter."
                + "\n" + GAME1
                + "\n" + GAME2
                + "\n" + GAME3
                + "\n" + GAME4
                + "\n" + GAME5
                + "\n" + GAME6
                + "\n" + GAME0);
        System.out.print("Your choice: ");
        String gameType = scanner.nextLine();

        switch (gameType) {
            case "1" -> Cli.greetPlayer();
            case "2" -> EvenGame.play();
            case "3" -> CalcGame.play();
            case "4" -> GcdGame.play();
            case "5" -> ProgressionGame.play();
            case "6" -> PrimeGame.play();
            case "0" -> System.exit(0);
            default -> System.out.println("Unknown game number: " + gameType);
        }
    }
}
