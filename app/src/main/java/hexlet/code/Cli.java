package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String playerName;

    public static String getPlayerName() {
        return playerName;
    }

    public static void greetPlayer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }
}
