package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void playEven() {
        int randomNumber = Engine.random.nextInt(100) + 1;

        System.out.println("Question: " + randomNumber);
        System.out.print("Your answer: ");
        String playerGuess = Engine.scanner.next();

        if ((playerGuess.equals("yes") && isEven(randomNumber))
                || (playerGuess.equals("no") && !isEven(randomNumber))) {
            System.out.println("Correct!");
            Engine.setCountCorrect();
        } else {
            String correctAnswer = isEven(randomNumber) ? "'yes'" : "'no'";
            System.out.println("'" + playerGuess + "'" + " is wrong answer ;(. Correct answer was "
                    + correctAnswer + ".");
            System.out.println("Let's try again, " + Engine.getPlayerName() + "!");
            Engine.setCountCorrect(4);
            }
    }
}
