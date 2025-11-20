package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class CalcGame {
    private static final int MAX_NUMBER = 100;
    private static final String CALC_TASK = "What is the result of the expression?";

    private static int generateResult(int number1, int number2, String operation) {
        return switch (operation) {
            case "-" -> number1 - number2;
            case "+" -> number1 + number2;
            case "*" -> number1 * number2;
            default -> throw new IllegalArgumentException("Unknown operation: " + operation);
        };
    }

    private static String[] makeGame() {
        int randomNumber1 = Utils.generateNumber(1, MAX_NUMBER);
        int randomNumber2 = Utils.generateNumber(1, MAX_NUMBER);
        int randomOperationIndex = Utils.generateNumber(0, 2);

        String[] operations = new String[]{"-", "+", "*"};
        String randomOperation = operations[randomOperationIndex];

        String quest = randomNumber1 + " " + randomOperation + " " + randomNumber2;
        String result = String.valueOf(generateResult(randomNumber1, randomNumber2, randomOperation));

        return new String[]{quest, result};
    }

    public static void play() {
        String[][] gameData = new String[Engine.ROUNDS][makeGame().length];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = makeGame();
        }
        Engine.manageGame(gameData, CALC_TASK);
    }
}
