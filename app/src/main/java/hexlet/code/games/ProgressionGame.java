package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class ProgressionGame {
    private static final int MAX_NUMBER = 50;
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 10;
    private static final int MIN_STEP = 2;
    private static final int MAX_STEP = 5;

    private static final String PROGRESSION_TASK = "What number is missing in the progression?";

    private static String[] generateProgression(int length, int step, int start) {
        String[] progression = new String[length];

        for (int index = 0; index < length; index++) {
            int currentElement = start + index * step;
            progression[index] = String.valueOf(currentElement);
        }
        return progression;
    }

    private static String[] makeGame() {
        int progressionLength = Utils.generateNumber(MIN_LENGTH, MAX_LENGTH);
        int startNumber = Utils.generateNumber(1, MAX_NUMBER);
        int step = Utils.generateNumber(MIN_STEP, MAX_STEP);
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
