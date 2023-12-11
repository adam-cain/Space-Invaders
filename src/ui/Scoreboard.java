package ui;

public class Scoreboard {
    ViewController viewController;
    
    public Scoreboard(){
        viewController = new ViewController();
    }

    public void updateScoreboard(int score, int lives){
        viewController.drawText("Score: " + score, 10, 10);
        viewController.drawText("Lives: " + lives, 10, 30);
    }
}
