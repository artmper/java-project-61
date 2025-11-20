package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public final class PrimeGame {
    private static final int MAX_NUMBER = 100;
    private static final String PRIME_TASK = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static boolean isPrime(int number) {
        int minPrime = 2;

        if (number == minPrime) {
            return true;
        }
        if (number < minPrime || number % 2 == 0) {
            return false;
        }
        for (int i = minPrime + 1; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String[] makeGame() {
        int randomNumber = Utils.generateNumber(1, MAX_NUMBER);
        String quest = String.valueOf(randomNumber);
        String result = isPrime(randomNumber) ? "yes" : "no";

        return new String[]{quest, result};
    }

    public static void play() {
        String[][] gameData = new String[Engine.ROUNDS][makeGame().length];

        for (int i = 0; i < gameData.length; i++) {
            gameData[i] = makeGame();
        }
        Engine.manageGame(gameData, PRIME_TASK);
    }
}
