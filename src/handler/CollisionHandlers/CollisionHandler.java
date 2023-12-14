package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import interfaces.Handler;

/**
 * An abstract class for handling collisions in the game.
 * It defines the basic structure and functionality for concrete collision handlers.
 */
public abstract class CollisionHandler implements Handler<CollisionPair> {

    protected Game game;
    private Handler<CollisionPair> next;

    /**
     * Constructs a new CollisionHandler with a reference to the game instance.
     *
     * @param game The game instance associated with this collision handler.
     */
    public CollisionHandler(Game game) {
        this.game = game;
    }

    /**
     * Gets the next handler in the chain of responsibility.
     *
     * @return The next collision handler.
     */
    @Override
    public Handler<CollisionPair> getNext() {
        return next;
    }

    /**
     * Sets the next handler in the chain of responsibility.
     *
     * @param next The next collision handler to set.
     */
    @Override
    public void setNext(Handler<CollisionPair> next) {
        this.next = next;
    }

    /**
     * Removes a projectile from the game.
     *
     * @param projectile The projectile to be removed.
     */
    protected void removeProjectile(Projectile projectile) {
        game.removeProjectile(projectile);
    }

    /**
     * Handles a collision request.
     * This method must be implemented by concrete subclasses to define specific collision handling behavior.
     *
     * @param input The collision pair to be handled.
     * @return true if the collision was handled, false otherwise.
     */
    @Override
    public abstract boolean handleRequest(CollisionPair input); 
}
