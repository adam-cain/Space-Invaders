package handler.InputHandlers;

import gameObjects.Player;

public class ShootHandler extends InputHandler {
    public ShootHandler(Player player) {
        super(player);
    }

    @Override
    public boolean handleRequest(KeyCode request) {
        if (request == KeyCode.SPACE) {
            player.shoot();
        } else if (getNext() != null) {
            getNext().handleRequest(request);
        }
        return false;
    }
}
