package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class EvenGame {
    private static final int MAX_NUMBER = 100;
    private static final String EVEN_TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    private static String[] makeGame() {
        int randomNumber = Utils.generateNumber(1, MAX_NUMBER);
        String quest = String.valueOf(randomNumber);
        String result = isEven(randomNumber) ? "yes" : "no";

        return new String[]{quest, result};
    }

    public static void play() {
        String[][] gameData = new String[Engine.ROUNDS][makeGame().length];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = makeGame();
        }
        Engine.manageGame(gameData, EVEN_TASK);
    }
}
