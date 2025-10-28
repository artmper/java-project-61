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
                + "\n" + game1 + "\n" + game2 + "\n" + game0);
        System.out.print("Your choice: ");
        userChoose = scanner.nextInt();


        switch(userChoose) {
            case 1:
                Cli.greetingPlayer();
                break;
            case 2:
                Cli.greetingPlayer();
                EvenGame.playEven();
                break;
            case 0:
            default:
                break;
        }
    }
}
