package gameObjects.AlienObjects;

import gameObjects.GameObject;
import interfaces.Collidable;
import interfaces.Moving;
import util.Image;

/**
 * Represents a generic alien in the game. This abstract class provides common
 * functionality for all alien types.
 */
public abstract class Alien extends GameObject implements Moving, Collidable {
    protected int points;
    protected boolean isAlive;

    /**
     * Constructs an Alien object with specified position, sprite image, and point value.
     *
     * @param xPosition The x-coordinate of the alien's initial position.
     * @param yPosition The y-coordinate of the alien's initial position.
     * @param sprite    The image representing the alien.
     * @param points    The point value of the alien when hit.
     */
    public Alien(int xPosition, int yPosition, Image sprite, int points) {
        super(xPosition, yPosition, sprite);
        this.points = points;
        this.isAlive = true;
    }

    /**
     * Marks the alien as hit, changing its status to not alive.
     */
    public void hit() {
        this.isAlive = false;
    }

    /**
     * Retrieves the point value of the alien.
     *
     * @return The point value of the alien.
     */
    public int getPoints() {
        return points;
    }

    /**
     * Checks whether the alien is still alive.
     *
     * @return True if the alien is alive, false otherwise.
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * Handles the collision event by marking the alien as not alive.
     */
    @Override
    public void handleCollision() {
        this.isAlive = false;
    }
}
