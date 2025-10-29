package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    private EvenGame() {
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void play() {
        int randomNumber = Engine.getRandom().nextInt(100) + 1;
        String quest = Integer.toString(randomNumber);
        Engine.printQuestion(quest);
        String playerGuess = Engine.getScanner().next();
        boolean gameResult = (playerGuess.equals("yes") && isEven(randomNumber))
                || (playerGuess.equals("no") && !isEven(randomNumber));
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";

        Engine.printResult(gameResult, playerGuess, correctAnswer);
    }
}
