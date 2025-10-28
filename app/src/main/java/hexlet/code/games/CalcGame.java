package hexlet.code.games;

import hexlet.code.Engine;

public class CalcGame {
    public static boolean isCorrect(int playerGuess, int number) {
        return playerGuess == number;
    }
    public static void playCalc() {
        int randomNumber1 = Engine.random.nextInt(100) + 1;
        int randomNumber2 = Engine.random.nextInt(100) + 1;
        int randomOperation = Engine.random.nextInt(3);
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
        System.out.println("Question: " + randomNumber1 + " " + operation + " " + randomNumber2);
        System.out.print("Your answer: ");
        int playerGuess = Engine.scanner.nextInt();

        if (isCorrect(playerGuess, result)) {
            System.out.println("Correct!");
            Engine.setCountCorrect();
        } else {
            String correctAnswer = "'" + result + "'";
            System.out.println("'" + playerGuess + "'" + " is wrong answer ;(. Correct answer was "
                    + correctAnswer + ".");
            System.out.println("Let's try again, " + Engine.getPlayerName() + "!");
            Engine.setCountCorrect(4);
        }
    }
}
