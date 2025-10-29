package hexlet.code.games;

import hexlet.code.Engine;

public class GcdGame {
    private GcdGame() {
    }
    public static String gcd(int number1, int number2) {
        while (number2 != 0) {
            int tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
        }
        return Integer.toString(number1);
    }
    public static void play() {
        int randomNumber1 = Engine.getRandom().nextInt(100) + 1;
        int randomNumber2 = Engine.getRandom().nextInt(100) + 1;

        String quest = randomNumber1 + " " + randomNumber2;
        Engine.printQuestion(quest);
        String playerGuess = Engine.getScanner().next();
        String correctAnswer = gcd(randomNumber1, randomNumber2);
        boolean gameResult = Engine.isCorrect(playerGuess, correctAnswer);

        Engine.printResult(gameResult, playerGuess, correctAnswer);
    }
}
