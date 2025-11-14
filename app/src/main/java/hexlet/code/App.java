package hexlet.code;

public class App {
    public static void playGame() {
        switch (Engine.getGameType()) {
            case "1" -> Engine.greetingPlayer();
            case "2", "3", "4", "5", "6" -> Engine.manageGame();
            case "0" -> System.exit(0);
            default -> System.out.println("Wrong game number. Choose between 0 to 6.");
        }
    }
    public static void main(String[] args) {
        Engine.setGameType();
        Engine.setGameResult();
        playGame();
    }
}
