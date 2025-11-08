package hexlet.code.games;

import hexlet.code.Engine;

public final class ProgressionGame {
    private static final int MAX_NUMBER = 50;
    private static final int MIN_LENGTH = 5;
    private static final int MIN_STEP = 2;
    private static final String PROGRESSION_TASK = "What number is missing in the progression?";

    private static String generateProgression(int length, int step, int start) {
        var progression = new StringBuilder();
        int currentElement;
        for (int index = 0; index < length; index++) {
            currentElement = start + index * step;
            progression.append(currentElement);
            if (index < length - 1) {
                progression.append(" ");
            }
        }
        return progression.toString();
    }

    private static String[] makeGame() {
        int progressionLength = Engine.getRandom().nextInt(MIN_LENGTH + 1) + MIN_LENGTH;
        int startNumber = Engine.getRandom().nextInt(MAX_NUMBER);
        int step = Engine.getRandom().nextInt(MIN_STEP + 1) + MIN_STEP;
        int missingIndex = Engine.getRandom().nextInt(progressionLength);

        String[] numbers = generateProgression(progressionLength, step, startNumber).split(" ");

        String result = numbers[missingIndex];
        numbers[missingIndex] = "..";

        String quest = "Question: " + String.join(" ", numbers);

        return new String[]{quest, result, PROGRESSION_TASK};
    }

    public static String[] getGame() {
        return makeGame();
    }
}
