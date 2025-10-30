package hexlet.code.games;

import hexlet.code.Engine;

public final class CalcGame {
    private static final int MAX_NUMBER = 100;
    private static final int OPERATIONS_COUNT = 3;

    private CalcGame() {
    }

    public static void play() {
        int randomNumber1 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        int randomNumber2 = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        int randomOperation = Engine.getRandom().nextInt(OPERATIONS_COUNT);

        String operation = switch (randomOperation) {
            case 0 -> "-";
            case 1 -> "+";
            case 2 -> "*";
            default -> "";
        };

        int result = switch (operation) {
            case "-" -> randomNumber1 - randomNumber2;
            case "+" -> randomNumber1 + randomNumber2;
            case "*" -> randomNumber1 * randomNumber2;
            default -> 0;
        };
        String quest = randomNumber1 + " " + operation + " " + randomNumber2;
        Engine.printQuestion(quest);
        String playerGuess = Engine.getScanner().next();

        String correctAnswer = Integer.toString(result);
        boolean gameResult = Engine.isCorrect(playerGuess, correctAnswer);

        Engine.printResult(gameResult, playerGuess, correctAnswer);
    }
}
