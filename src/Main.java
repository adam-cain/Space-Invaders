import core.Game;
import ui.ViewController;
import ui.interfaces.ClickListener;
import ui.GameOverScene;
import ui.StartMenuScene;

public class Main {
    private static ViewController viewController;
    private static Game game;

    public static void main(String[] args) {
        viewController = ViewController.getInstance();
        game = Game.getInstance();
        while(true) {
            loadStartMenuScene();
        }
    }

    public static void loadStartMenuScene() {
        ClickListener startButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                int finalScore = game.startGame(); // Start the game and get the final score
                loadGameOverScene(finalScore); // Load the game over scene with the final score
                return;
            }
        };
        StartMenuScene startMenuScene = new StartMenuScene(startButtonListener);
        viewController.loadScene(startMenuScene);
    }

    public static void loadGameOverScene(int finalScore) {
        ClickListener restartButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                int finalScore = game.startGame(); // Start the game and get the final score
                loadGameOverScene(finalScore); // Load the game over scene with the final score
                return;
            }
        };
        ClickListener mainMenuButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                loadStartMenuScene(); // Load the start menu scene
                return;
            }
        };
        GameOverScene gameOverScene = new GameOverScene(finalScore, restartButtonListener, mainMenuButtonListener);
        viewController.loadScene(gameOverScene);
    }
}

