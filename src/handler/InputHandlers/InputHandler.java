package handler.InputHandlers;

import gameObjects.Player;
import interfaces.Handler;

/**
 * An abstract class for handling input events for a Player in the game.
 * It defines the basic structure and functionality for concrete input handlers.
 */
public abstract class InputHandler implements Handler<KeyCode> {
    private Handler<KeyCode> next;
    protected Player player;

    /**
     * Constructs a new InputHandler with a reference to the player instance.
     *
     * @param player The player who will be affected by the input events.
     */
    public InputHandler(Player player) {
        this.player = player;
    }

    /**
     * Sets the next handler in the chain of responsibility for input handling.
     *
     * @param next The next input handler to set.
     */
    @Override
    public void setNext(Handler<KeyCode> next) {
        this.next = next;
    }

    /**
     * Gets the next handler in the chain of responsibility for input handling.
     *
     * @return The next input handler.
     */
    @Override
    public Handler<KeyCode> getNext() {
        return next;
    }

    // Implementations of the handleRequest method should be provided in subclasses.
}
