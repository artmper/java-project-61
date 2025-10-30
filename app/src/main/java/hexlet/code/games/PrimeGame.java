package hexlet.code.games;

import hexlet.code.Engine;

public final class PrimeGame {
    private static final int MAX_NUMBER = 100;

    private PrimeGame() {

    }
    public static boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        if (number < 2 || number % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void play() {
        int randomNumber = Engine.getRandom().nextInt(MAX_NUMBER) + 1;

        String quest = Integer.toString(randomNumber);
        Engine.printQuestion(quest);
        String playerGuess = Engine.getScanner().next();

        boolean gameResult = (playerGuess.equals("yes") && isPrime(randomNumber))
                || (playerGuess.equals("no") && !isPrime(randomNumber));

        String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
        Engine.printResult(gameResult, playerGuess, correctAnswer);
    }
}
