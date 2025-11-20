package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS = 3;

    public static void manageGame(String[][] data, String task) {
        Scanner scanner = new Scanner(System.in);
        int countCorrect = 0;

        Cli.greetPlayer();
        System.out.println(task);

        for (String[] round : data) {
            System.out.println("Question: " + round[0]);
            System.out.print("Your answer: ");
            String playerGuess = scanner.nextLine();
            String correctAnswer = round[1];

            if (playerGuess.equals(correctAnswer)) {
                System.out.println("Correct!");
                countCorrect++;
            } else {
                System.out.println("'" + playerGuess + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + Cli.getPlayerName() + "!");
                break;
            }
        }

        if (countCorrect == ROUNDS) {
            System.out.println("Congratulations, " + Cli.getPlayerName() + "!");
        }

        scanner.close();
    }
}
