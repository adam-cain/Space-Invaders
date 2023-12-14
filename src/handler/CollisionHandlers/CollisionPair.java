package handler.CollisionHandlers;

import gameObjects.Projectile;
import interfaces.Collidable;

/**
 * Represents a pair of objects involved in a collision in the game.
 * This class encapsulates a projectile and another collidable object, typically used in collision handling.
 */
public class CollisionPair {
    private Projectile projectile;
    private Collidable collidable;

    /**
     * Constructs a new CollisionPair with a specified projectile and collidable object.
     *
     * @param projectile The projectile involved in the collision.
     * @param collidable The collidable object involved in the collision.
     */
    public CollisionPair(Projectile projectile, Collidable collidable) {
        this.projectile = projectile;
        this.collidable = collidable;
    }

    /**
     * Retrieves the projectile involved in the collision.
     *
     * @return The projectile in this collision pair.
     */
    public Projectile getProjectile() {
        return this.projectile;
    }

    /**
     * Retrieves the collidable object involved in the collision.
     *
     * @return The collidable object in this collision pair.
     */
    public Collidable getCollidable() {
        return this.collidable;
    }
}
