package gameObjects.AlienObjects;

import gameObjects.GameObject;
import gameObjects.MovementBehavior.LinearDown;
import interfaces.MovementBehavior;
import interfaces.Shooting;
import util.Image;

/**
 * Represents an abstract alien object with shooting capabilities.
 * This class extends the Alien class and implements the Shooting interface.
 */
public abstract class ShootingAlien extends Alien implements Shooting {
    
    /**
     * Constructor to initialize a ShootingAlien object.
     * 
     * @param xPosition the x-coordinate of the alien.
     * @param yPosition the y-coordinate of the alien.
     * @param sprite the image representing the alien.
     * @param points the points associated with the alien.
     */
    public ShootingAlien(int xPosition, int yPosition, Image sprite, int points) {
        super(xPosition, yPosition, sprite, points);
    }

    /**
     * Returns this ShootingAlien instance.
     * 
     * @return the current instance of ShootingAlien.
     */
    @Override
    public GameObject getThis() {
        return this;
    }

    /**
     * Provides the movement behavior for the projectile.
     * 
     * @return a new instance of LinearDown, representing the projectile's movement behavior.
     */
    @Override
    public MovementBehavior getProjectileBehavior() {
        return new LinearDown();
    }

    /**
     * Provides the sprite for the projectile.
     * 
     * @return a new Image instance representing the projectile's sprite.
     */
    @Override
    public Image getProjectileSprite() {
        return new Image("src/assets/alienProjectile.png", 10, 40);
    }
}
