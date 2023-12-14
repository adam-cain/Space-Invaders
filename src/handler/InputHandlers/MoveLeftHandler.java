package handler.InputHandlers;

import gameObjects.Player;

/**
 * Handles the input for moving the player to the left in the game.
 * This class responds to specific key codes that correspond to the left movement action.
 */
public class MoveLeftHandler extends InputHandler {

    /**
     * Constructs a new MoveLeftHandler with a reference to the player.
     *
     * @param player The player who will be moved left by this handler.
     */
    public MoveLeftHandler(Player player) {
        super(player);
    }

    /**
     * Handles the input request for moving the player to the left.
     * If the request matches the keys for moving left, the player is moved accordingly.
     *
     * @param request The KeyCode representing the player's input.
     * @return true if the request was handled, false otherwise.
     */
    @Override
    public boolean handleRequest(KeyCode request) {
        if (request == KeyCode.A || request == KeyCode.ARROW_LEFT) {
            player.moveLeft();
            return true; // Indicate that the request was handled
        } else if (getNext() != null) {
            return getNext().handleRequest(request); // Pass to the next handler
        }
        return false; // Indicate that the request was not handled
    }
}
