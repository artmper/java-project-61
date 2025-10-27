package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    private static final Random RANDOM = new Random();

    public static void playEven() {
        var scanner = new Scanner(System.in);
        int randomNumber;
        String playerGuess;
        int countCorrect = 0;
        String correctAnswer = "Correct!";
        String playerName = Cli.getPlayerName();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while(countCorrect < 3) {
            randomNumber = RANDOM.nextInt(100) + 1;
            System.out.println("Question: " + randomNumber);
            System.out.print("Your answer: ");
            playerGuess = scanner.nextLine();

            if ((playerGuess.equals("yes") && isEven(randomNumber))
                    || (playerGuess.equals("no") && !isEven(randomNumber))) {
                System.out.println(correctAnswer);
                countCorrect++;
            } else {
                correctAnswer = isEven(randomNumber) ? "'yes'" : "'no'";
                System.out.println("'" + playerGuess + "'" + " is wrong answer ;(. Correct answer was "
                        + correctAnswer + ".");
                System.out.println("Let's try again, " + playerName + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
