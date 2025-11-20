package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class ProgressionGame {
    private static final int MAX_NUMBER = 50;
    private static final String PROGRESSION_TASK = "What number is missing in the progression?";

    private static String[] generateProgression(int length, int step, int start) {
        String[] progression = new String[length];
        int currentElement;

        for (int index = 0; index < length; index++) {
            currentElement = start + index * step;
            progression[index] = String.valueOf(currentElement);
        }
        return progression;
    }

    private static String[] makeGame() {
        final int maxLength = 10;
        final int minStep = 2;
        final int maxStep = 5;

        int progressionLength = Utils.generateNumber(5, maxLength);
        int startNumber = Utils.generateNumber(1, MAX_NUMBER);
        int step = Utils.generateNumber(minStep, maxStep);
        int missingIndex = Utils.generateNumber(0, progressionLength - 1);

        String[] numbers = generateProgression(progressionLength, step, startNumber);
        String result = numbers[missingIndex];
        numbers[missingIndex] = "..";
        String quest = String.join(" ", numbers);

        return new String[]{quest, result};
    }

    public static void play() {
        String[][] gameData = new String[Engine.ROUNDS][makeGame().length];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = makeGame();
        }
        Engine.manageGame(gameData, PROGRESSION_TASK);
    }
}
