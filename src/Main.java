import core.Game;
import ui.ViewController;
import ui.interfaces.ClickListener;
import ui.StartMenuScene;

public class Main {
    public static void main(String[] args) {
        ViewController viewController = ViewController.getInstance();
        
        ClickListener startButtonListener = new ClickListener() {
            @Override
            public void onClick() {
                Game game = Game.getInstance();
                game.startGame();
            }
        };

        viewController.loadScene(new StartMenuScene(startButtonListener));
    }
}
