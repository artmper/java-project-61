package hexlet.code.games;

import hexlet.code.Engine;

public final class ProgressionGame {
    private static final int MAX_NUMBER = 50;
    private static final int MIN_LENGTH = 5;
    private static final int MIN_STEP = 2;
    private static int correctNumber;

    private ProgressionGame() {

    }
    public static void setCorrectNumber(int number) {
       correctNumber = number;
    }

    public static String generateProgression() {
        int progressionLength = Engine.getRandom().nextInt(MIN_LENGTH + 1) + MIN_LENGTH;
        int missingIndex = Engine.getRandom().nextInt(progressionLength);
        int startNumber = Engine.getRandom().nextInt(MAX_NUMBER);
        int step = Engine.getRandom().nextInt(MIN_STEP + 1) + MIN_STEP;

        var progression = new StringBuilder();
        int currentElement;

        for (int index = 0; index < progressionLength; index++) {
            currentElement = startNumber + index * step;
            if (index != missingIndex) {
                progression.append(currentElement).append(" ");
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
