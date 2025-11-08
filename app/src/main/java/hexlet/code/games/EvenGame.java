package hexlet.code.games;

import hexlet.code.Engine;

public final class EvenGame {
    private static final int MAX_NUMBER = 100;
    private static final String EVEN_TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    private static String generateResult(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    private static String[] makeGame() {
        int randomNumber = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        String quest = "Question: " + randomNumber;
        String result = generateResult(randomNumber);

        return new String[]{quest, result, EVEN_TASK};
    }

    public static String[] getGame() {
        return makeGame();
    }

}
