package ui;

import java.awt.Dimension;

import ui.uiObjects.*;

public class GameOverScene extends Scene {
    private Button restartButton;
    private Button mainMenuButton;
    private Label gameOverLabel;
    private Label finalScoreLabel;

    public GameOverScene(int score) {
        Dimension windowSize = ViewController.getWindowSize();

        // Game Over Label
        gameOverLabel = new Label("gameOverLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 60, 200, 40, "Game Over");

        // Final Score Label (assuming you have a way to get the final score)
        finalScoreLabel = new Label("finalScoreLabel", windowSize.width / 2 - 100, windowSize.height / 2 - 20, 200, 40, "Score: "+score);

        // Restart Button
        restartButton = new restartButton("restartButton", windowSize.width / 2 - 100, windowSize.height / 2 + 20, 200, 40, "Restart");

        // Main Menu Button
        mainMenuButton = new mainMenuButton("mainMenuButton", windowSize.width / 2 - 100, windowSize.height / 2 + 60, 200, 40, "Main Menu");

        addUIObject(gameOverLabel);
        addUIObject(finalScoreLabel);
        addUIObject(restartButton);
        addUIObject(mainMenuButton);
    }

    @Override
    public void update(Object... args) {
    }
}

class restartButton extends Button{
    public restartButton(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height, text);
    }

    @Override
    public void onClick() {
        // Restart Game
        //TODO: Restart Game
    }
}

class mainMenuButton extends Button{
    public mainMenuButton(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height, text);
    }

    @Override
    public void onClick() {
        ViewController vc = ViewController.getInstance();
        vc.loadScene(new StartMenuScene());
    }
}
