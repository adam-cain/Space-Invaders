package ui;

import java.awt.Dimension;

import ui.interfaces.ClickListener;
import ui.uiObjects.*;

public class GameOverScene extends Scene {
    private Button restartButton;
    private Button mainMenuButton;
    private Label gameOverLabel;
    private Label finalScoreLabel;

    public GameOverScene(int score, ClickListener restartListener, ClickListener mainMenuListener) {
        Dimension windowSize = ViewController.getWindowSize();

        // Game Over Label
        gameOverLabel = new Label("gameOverLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 60, 200, 40, "Game Over");

        // Final Score Label (assuming you have a way to get the final score)
        finalScoreLabel = new Label("finalScoreLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 20, 200, 40, "Score: "+score);

        // Restart Button
        restartButton = new RestartButton("restartButton", windowSize.width / 2 - 100, windowSize.height / 2 + 20, 200, 40, "Restart", restartListener);

        // Main Menu Button
        mainMenuButton = new MainMenuButton("mainMenuButton", windowSize.width / 2 - 100, windowSize.height / 2 + 60, 200, 40, "Main Menu", mainMenuListener);

        addUIObject(gameOverLabel);
        addUIObject(finalScoreLabel);
        addUIObject(restartButton);
        addUIObject(mainMenuButton);
    }

    @Override
    public void update(Object... args) {
    }
}

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
