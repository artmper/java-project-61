package hexlet.code.games;

import hexlet.code.Engine;

public class ProgressionGame {
    private static int correctNumber;

    private ProgressionGame() {

    }
    public static void setCorrectNumber(int correctNumber) {
        ProgressionGame.correctNumber = correctNumber;
    }

    public static String generateProgression() {
        int progressionLength = Engine.getRandom().nextInt(6) + 5;
        int missingIndex = Engine.getRandom().nextInt(progressionLength);
        int startNumber = Engine.getRandom().nextInt(50);
        int step = Engine.getRandom().nextInt(5) + 2;

        var progression = new StringBuilder();
        int currentElement;

        for (int index = 0; index < progressionLength; index++) {
            currentElement = startNumber + index * step;
            if (index != missingIndex) {
                progression.append(Integer.toString(currentElement)).append(" ");
                continue;
            }
            progression.append("..").append(" ");
            setCorrectNumber(currentElement);
        }
        return progression.toString();
    }

    public static void play() {
        String quest = generateProgression();
        Engine.printQuestion(quest);
        String playerGuess = Engine.getScanner().next();

        String correctAnswer = Integer.toString(correctNumber);
        boolean gameResult = Engine.isCorrect(playerGuess, correctAnswer);

        Engine.printResult(gameResult, playerGuess, correctAnswer);
    }
}
