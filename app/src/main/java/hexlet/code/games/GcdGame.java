package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GcdGame {
    private static final int MAX_NUMBER = 100;
    private static final String GCD_TASK = "Find the greatest common divisor of given numbers.";

    private static String getGcd(int number1, int number2) {
        while (number2 != 0) {
            int tmp = number1 % number2;
            number1 = number2;
            number2 = tmp;
        }
        return Integer.toString(number1);
    }

    private static String[] makeGame() {
        int randomNumber1 = Utils.generateNumber(1, MAX_NUMBER);
        int randomNumber2 = Utils.generateNumber(1, MAX_NUMBER);
        String quest = randomNumber1 + " " + randomNumber2;
        String result = getGcd(randomNumber1, randomNumber2);

        return new String[]{quest, result};
    }

    public static void play() {
        String[][] gameData = new String[Engine.ROUNDS][makeGame().length];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = makeGame();
        }
        Engine.manageGame(gameData, GCD_TASK);
    }
}
