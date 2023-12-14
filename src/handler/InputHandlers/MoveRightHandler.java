package handler.InputHandlers;

import gameObjects.Player;

/**
 * Handles the input for moving the player to the right in the game.
 * This class responds to specific key codes that correspond to the right movement action.
 */
public class MoveRightHandler extends InputHandler {

    /**
     * Constructs a new MoveRightHandler with a reference to the player.
     *
     * @param player The player who will be moved right by this handler.
     */
    public MoveRightHandler(Player player) {
        super(player);
    }

    /**
     * Handles the input request for moving the player to the right.
     * If the request matches the keys for moving right, the player is moved accordingly.
     *
     * @param request The KeyCode representing the player's input.
     * @return true if the request was handled, false otherwise.
     */
    @Override
    public boolean handleRequest(KeyCode request) {
        if (request == KeyCode.D || request == KeyCode.ARROW_RIGHT) {
            player.moveRight();
            return true; // Indicate that the request was handled
        } else if (getNext() != null) {
            return getNext().handleRequest(request); // Pass to the next handler
        }
        return false; // Indicate that the request was not handled
    }
}
