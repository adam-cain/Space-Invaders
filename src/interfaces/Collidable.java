package interfaces;

import gameObjects.Projectile;

/**
 * An interface representing objects that can collide with others in a game.
 * It extends the Positionable interface, adding collision handling capabilities.
 */
public interface Collidable extends Positionable {

    /**
     * Handles the collision event for the implementing object.
     * This method should define the specific actions to take when a collision occurs.
     */
    void handleCollision();

    /**
     * Checks if this object collides with a given projectile.
     * The method uses the position and size of both this object and the projectile to determine if they intersect.
     *
     * @param object The projectile to check collision against.
     * @return true if there is a collision, false otherwise.
     */
    default boolean collides(Projectile object) {
        // Check if the right edge of 'this' is left of the left edge of 'object'
        if (getX() + getWidth() <= object.getX()) {
            return false;
        }
    
        // Check if the left edge of 'this' is right of the right edge of 'object'
        if (getX() >= object.getX() + object.getWidth()) {
            return false;
        }
    
        // Check if the bottom edge of 'this' is above the top edge of 'object'
        if (getY() + getHeight() <= object.getY()) {
            return false;
        }
    
        // Check if the top edge of 'this' is below the bottom edge of 'object'
        if (getY() >= object.getY() + object.getHeight()) {
            return false;
        }
    
        // If none of the above, the objects intersect
        handleCollision();
        return true;
    }
}
