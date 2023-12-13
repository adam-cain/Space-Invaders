package ui;

import ui.uiObjects.Scene;
import ui.uiObjects.*;

public class ScoreboardScene extends Scene{

    Label scoreLabel;
    Label livesLabel;

    public ScoreboardScene(){
        scoreLabel = new Label("scoreLabel", 10, 10, 100, 20, "Score: 0");
        livesLabel = new Label("livesLabel", 10, 100, 100, 20, "Lives: 3");
        addUIObject(livesLabel);
        addUIObject(scoreLabel);
    }

    public void updateScoreboard(int score, int lives) {
        scoreLabel.setText("Score: " + score);
        livesLabel.setText("Lives: " + lives);
    }

    @Override
    public void update(Object... args) {
        scoreLabel.setText("Score: " + (int)args[0]);
        livesLabel.setText("Lives: " + (int)args[1]);
    }
}
