package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    private CalcGame() {
    }

    public static void play() {
        int randomNumber1 = Engine.getRandom().nextInt(100) + 1;
        int randomNumber2 = Engine.getRandom().nextInt(100) + 1;
        int randomOperation = Engine.getRandom().nextInt(3);
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
