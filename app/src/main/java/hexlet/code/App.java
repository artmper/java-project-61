package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String game1 = "1 - Greet";
        String game2 = "2 - Even";
        String game0 = "0 - Exit";
        int userChoose;

        System.out.println("Please enter the game number and press Enter."
                + "\n" + game1 + "\n" + game0 + "\n" + game2);
        userChoose = scanner.nextInt();
        System.out.println("Your choice: " + userChoose + "\n");

        switch(userChoose) {
            case 1:
                Cli.greetingPlayer();
            case 2:
                Cli.greetingPlayer();
                EvenGame.playEven();
            case 0:
            default:
                break;
        }
    }
}
