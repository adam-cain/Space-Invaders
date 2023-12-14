package gameObjects;

import java.awt.Dimension;
import interfaces.Moving;
import interfaces.MovementBehavior;
import ui.ViewController;
import util.Image;

/**
 * Represents a projectile in the game, which can be fired by a GameObject.
 * This class manages the movement and state of the projectile.
 */
public class Projectile extends GameObject implements Moving {

    private final MovementBehavior behavior;
    private final GameObject shooter;
    private final int projectileSpeed;

    /**
     * Constructs a new Projectile object with specified position, movement behavior, speed, sprite, and shooter.
     *
     * @param xPosition        The x-coordinate of the projectile's initial position.
     * @param yPosition        The y-coordinate of the projectile's initial position.
     * @param behavior         The movement behavior of the projectile.
     * @param projectileSpeed  The speed of the projectile.
     * @param sprite           The image representing the projectile.
     * @param shooter          The GameObject that shot the projectile.
     */
    public Projectile(int xPosition, int yPosition, MovementBehavior behavior, int projectileSpeed, Image sprite, GameObject shooter) {
        super(xPosition, yPosition, sprite);
        this.behavior = behavior;
        this.shooter = shooter;
        this.projectileSpeed = projectileSpeed;
    }

    /**
     * Updates the projectile's position based on its behavior and speed.
     */
    public void update() {
        behavior.execute(this, projectileSpeed);
    }

    /**
     * Gets the GameObject that shot this projectile.
     *
     * @return The shooter GameObject.
     */
    public GameObject getShooter() {
        return shooter;
    }

    /**
     * Checks if the projectile is out of the game window bounds.
     *
     * @return true if the projectile is out of bounds, false otherwise.
     */
    public boolean isOutOfBounds() {
        Dimension windowSize = ViewController.getWindowSize();
        return getX() < 0 || getX() > windowSize.getWidth() || getY() < 0 || getY() > windowSize.getHeight();
    }
}
