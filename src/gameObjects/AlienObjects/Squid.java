package gameObjects.AlienObjects;

import util.Image;

/**
 * Represents a Squid alien object, which is a specific type of ShootingAlien.
 * This class extends ShootingAlien and provides specific implementations for Squid aliens.
 */
public class Squid extends ShootingAlien {
    
    /**
     * Static sprite image for all Squid instances.
     */
    private static Image sprite = new Image("src/assets/squid.png", 40, 40);

    /**
     * Constructor to initialize a Squid object.
     * 
     * @param xPosition the x-coordinate of the Squid.
     * @param yPosition the y-coordinate of the Squid.
     */
    public Squid(int xPosition, int yPosition) {
        super(xPosition, yPosition, sprite, 40);
    }

    /**
     * Provides the speed of the projectile shot by the Squid.
     * 
     * @return an integer representing the speed of the projectile.
     */
    @Override
    public int getProjectileSpeed() {
        return 3;
    }
}
