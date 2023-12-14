package handler.InputHandlers;

import gameObjects.Player;

/**
 * Handles the input for the shooting action of the player in the game.
 * This class responds to the specific key code that corresponds to the shooting action.
 */
public class ShootHandler extends InputHandler {

    /**
     * Constructs a new ShootHandler with a reference to the player.
     *
     * @param player The player who will perform the shooting action by this handler.
     */
    public ShootHandler(Player player) {
        super(player);
    }

    /**
     * Handles the input request for the player's shooting action.
     * If the request matches the key for shooting, the player performs the shoot action.
     *
     * @param request The KeyCode representing the player's input for shooting.
     * @return true if the request was handled, false otherwise.
     */
    @Override
    public boolean handleRequest(KeyCode request) {
        if (request == KeyCode.SPACE) {
            player.shoot();
            return true; // Indicate that the request was handled
        } else if (getNext() != null) {
            return getNext().handleRequest(request); // Pass to the next handler
        }
        return false; // Indicate that the request was not handled
    }
}
