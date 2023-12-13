package handler.InputHandlers;

import gameObjects.Player;

public class MoveRightHandler extends InputHandler{

    public MoveRightHandler(Player player) {
        super(player);
    }

    @Override
    public boolean handleRequest(KeyCode request) {
        if (request == KeyCode.D || request == KeyCode.ARROW_RIGHT) {
            player.moveRight();
        } else if (getNext() != null) {
            getNext().handleRequest(request);
        }
        return false;
    }
}
