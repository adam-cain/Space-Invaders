import core.Game;
import ui.ViewController;
import ui.interfaces.ClickListener;
import ui.GameOverScene;
import ui.StartMenuScene;

/**
 * The {@code Main} class serves as the entry point for the Space Invaders game.
 * It initializes and manages the main game components, including the {@code ViewController} and {@code Game} instances,
 * and controls the transition between different scenes such as the start menu and game over scenes.
 */
public class Main {
    private static ViewController viewController;
    private static Game game;

    /**
     * The main method to start the game application.
     * Initializes the game and loads the start menu scene.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        viewController = ViewController.getInstance();
        game = Game.getInstance();
        loadStartMenuScene();
    }

    /**
     * Loads and displays the start menu scene.
     * Sets up the click listener for the start button to begin the game.
     */
    public static void loadStartMenuScene() {
        ClickListener startButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                int finalScore = game.startGame(); // Start the game and get the final score
                System.out.println("Final Score: " + finalScore);
                loadGameOverScene(finalScore); // Load the game over scene with the final score
            }
        };
        StartMenuScene startMenuScene = new StartMenuScene(startButtonListener);
        viewController.loadScene(startMenuScene);
    }

    /**
     * Loads and displays the game over scene.
     * Sets up the click listeners for the restart and main menu buttons.
     * 
     * @param finalScore the final score achieved in the game
     */
    public static void loadGameOverScene(int finalScore) {
        ClickListener restartButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                loadStartMenuScene(); // Reload the start menu scene
            }
        };
        ClickListener mainMenuButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                loadStartMenuScene(); // Load the start menu scene
            }
        };
        GameOverScene gameOverScene = new GameOverScene(finalScore, restartButtonListener, mainMenuButtonListener);
        viewController.loadScene(gameOverScene);
    }
}
