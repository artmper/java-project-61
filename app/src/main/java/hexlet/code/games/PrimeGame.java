package hexlet.code.games;

import hexlet.code.Engine;

public final class PrimeGame {
    private static final int MAX_NUMBER = 100;
    private static final String PRIME_TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    private static String generateResult(int number) {
        return Engine.isPrime(number) ? "yes" : "no";
    }

    private static String[] makeGame() {
        int randomNumber = Engine.getRandom().nextInt(MAX_NUMBER) + 1;
        String quest = "Question: " + randomNumber;
        String result = generateResult(randomNumber);

        return new String[]{quest, result, PRIME_TASK};
    }

    public static String[] getGame() {
        return makeGame();
    }
}
