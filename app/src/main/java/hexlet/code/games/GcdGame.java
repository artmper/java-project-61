package hexlet.code.games;

import hexlet.code.Engine;

public final class GcdGame {
    private static final int MAX_NUMBER = 100;
    private static final String GCD_TASK = "Find the greatest common divisor of given numbers.";

    private static String generateResult(int number1, int number2) {
        while (number2 != 0) {
            int tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
        }
        return Integer.toString(number1);
    }

    private static String[] makeGame() {
        int randomNumber1 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        int randomNumber2 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        String quest = "Question: " + randomNumber1 + " " + randomNumber2;
        String result = generateResult(randomNumber1, randomNumber2);

        return new String[]{quest, result, GCD_TASK};
    }

    public static String[] getGame() {
        return makeGame();
    }
}
