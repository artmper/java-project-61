package hexlet.code;

import java.util.Scanner;

public final class Engine {
    public static final int ROUNDS = 3;

    public static void manageGame(String[][] data, String task) {
        Scanner scanner = new Scanner(System.in);
        int countCorrect = 0;

        System.out.println("\nWelcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String playerName = scanner.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(task);

        for (String[] round : data) {
            System.out.println("Question: " + round[0]);
            System.out.print("Your answer: ");
            String playerGuess = scanner.next();
            String correctAnswer = round[1];

            if (playerGuess.equals(correctAnswer)) {
                System.out.println("Correct!");
                countCorrect++;
            } else {
                System.out.println("'" + playerGuess + "'" + " is wrong answer ;(. Correct answer was "
                        + "'" + correctAnswer + "'" + ".");
                System.out.println("Let's try again, " + playerName + "!");
                break;
            }
        }

        if (countCorrect == ROUNDS) {
            System.out.println("Congratulations, " + playerName + "!");
        }

        scanner.close();
    }
}
