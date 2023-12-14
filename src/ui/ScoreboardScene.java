package ui;

import ui.uiObjects.Scene;
import ui.uiObjects.*;

/**
 * The {@code ScoreboardScene} class represents a scene in the Space Invaders game that displays the player's score and remaining lives.
 * This class extends the {@code Scene} class and includes label elements to show the current score and number of lives.
 */
public class ScoreboardScene extends Scene{

    Label scoreLabel;
    Label livesLabel;

    /**
     * Constructs a new {@code ScoreboardScene} instance.
     * Initializes labels for score and lives, positioning them within the scene.
     */
    public ScoreboardScene(){
        scoreLabel = new Label("scoreLabel", 10, 10, 100, 20, "Score: 0");
        livesLabel = new Label("livesLabel", 10, 100, 100, 20, "Lives: 3");

        // Adding the labels to the scene
        addUIObject(scoreLabel);
        addUIObject(livesLabel);
    }

    /**
     * Updates the scoreboard with the current score and number of lives.
     * 
     * @param score the player's current score
     * @param lives the player's remaining lives
     */
    public void updateScoreboard(int score, int lives) {
        scoreLabel.setText("Score: " + score);
        livesLabel.setText("Lives: " + lives);
    }

    /**
     * Overrides the {@code update} method of the {@code Scene} class.
     * Updates the score and lives labels based on the provided arguments.
     * 
     * @param args arguments provided to the update method, expected to be the score and number of lives
     */
    @Override
    public void update(Object... args) {
        scoreLabel.setText("Score: " + (int)args[0]);
        livesLabel.setText("Lives: " + (int)args[1]);
    }
}
