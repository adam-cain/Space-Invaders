package ui;

import java.awt.Dimension;

import ui.interfaces.ClickListener;
import ui.uiObjects.*;

/**
 * The {@code GameOverScene} class represents the game over screen in the Space Invaders game.
 * It displays the final score and provides options to restart the game or return to the main menu.
 */
public class GameOverScene extends Scene {
    private Button restartButton;
    private Button mainMenuButton;
    private Label gameOverLabel;
    private Label finalScoreLabel;

    /**
     * Constructs a new GameOverScene with specified parameters.
     * 
     * @param score           the final score to be displayed
     * @param restartListener a {@code ClickListener} for the restart button
     * @param mainMenuListener a {@code ClickListener} for the main menu button
     */
    public GameOverScene(int score, ClickListener restartListener, ClickListener mainMenuListener) {
        Dimension windowSize = ViewController.getWindowSize();

        // Initializing UI components
        gameOverLabel = new Label("gameOverLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 60, 200, 40, "Game Over");
        finalScoreLabel = new Label("finalScoreLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 20, 200, 40, "Score: " + score);
        restartButton = new RestartButton("restartButton", windowSize.width / 2 - 100, windowSize.height / 2 + 20, 200, 40, "Restart", restartListener);
        mainMenuButton = new MainMenuButton("mainMenuButton", windowSize.width / 2 - 100, windowSize.height / 2 + 60, 200, 40, "Main Menu", mainMenuListener);

        // Adding UI components to the scene
        addUIObject(gameOverLabel);
        addUIObject(finalScoreLabel);
        addUIObject(restartButton);
        addUIObject(mainMenuButton);
    }

    @Override
    public void update(Object... args) {
        // Update logic for the GameOverScene can be implemented here if needed
    }
}

/**
 * A specialized button for restarting the game.
 */
class RestartButton extends Button {
    private ClickListener listener;

    public RestartButton(String name, int x, int y, int width, int height, String text, ClickListener listener) {
        super(name, x, y, width, height, text);
        this.listener = listener;
    }

    @Override
    public void onClick() {
        if (listener != null) {
            listener.onClick();
        }
    }
}

/**
 * A specialized button for returning to the main menu.
 */
class MainMenuButton extends Button {
    private ClickListener listener;

    public MainMenuButton(String name, int x, int y, int width, int height, String text, ClickListener listener) {
        super(name, x, y, width, height, text);
        this.listener = listener;
    }

    @Override
    public void onClick() {
        if (listener != null) {
            listener.onClick();
        }
    }
}
