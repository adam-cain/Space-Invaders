package handler.InputHandlers;

import gameObjects.Player;

public class MoveLeftHandler extends InputHandler {

    public MoveLeftHandler(Player player) {
        super(player);
    }

    @Override
    public void handleRequest(KeyCode request) {
        if (request == KeyCode.A || request == KeyCode.ARROW_LEFT) {
            player.moveLeft();
        } else if (getNext() != null) {
            getNext().handleRequest(request);
        }
    }
}
