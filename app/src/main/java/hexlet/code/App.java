package hexlet.code;

public class App {
    public static void main(String[] args) {
        Engine.setGameType();
        Engine.setGameTask(Engine.getGameType());
        Engine.playGame();
    }
}
