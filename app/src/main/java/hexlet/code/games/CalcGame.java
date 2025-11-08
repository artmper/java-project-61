package hexlet.code.games;

import hexlet.code.Engine;

public final class CalcGame {
    private static final int MAX_NUMBER = 100;
    private static final int OPERATIONS_COUNT = 3;
    private static final String CALC_TASK = "What is the result of the expression?";

    private static int generateResult(int number1, int number2, String operation) {
        return switch (operation) {
            case "-" -> number1 - number2;
            case "+" -> number1 + number2;
            case "*" -> number1 * number2;
            default -> 0;
        };
    }

    private static String[] makeGame() {
        int randomNumber1 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        int randomNumber2 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        int randomOperation = Engine.getRandom().nextInt(OPERATIONS_COUNT);

        String operation = switch (randomOperation) {
            case 0 -> "-";
            case 1 -> "+";
            case 2 -> "*";
            default -> "";
        };

        String quest = "Question: " + randomNumber1 + " " + operation + " " + randomNumber2;
        String result = String.valueOf(generateResult(randomNumber1, randomNumber2, operation));

        return new String[]{quest, result, CALC_TASK};
    }

    public static String[] getGame() {
        return makeGame();
    }
}
