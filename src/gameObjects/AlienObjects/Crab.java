package gameObjects.AlienObjects;

import util.Image;

/**
 * Represents a 'Crab' type alien in the game.
 * This class extends ShootingAlien, providing specific functionality for the Crab alien.
 */
public class Crab extends ShootingAlien {
    private static final Image SPRITE = new Image("src/assets/crab.png", 40, 40);

    /**
     * Constructs a new Crab alien with specified position coordinates.
     * 
     * @param xPosition The x-coordinate of the crab's initial position.
     * @param yPosition The y-coordinate of the crab's initial position.
     */
    public Crab(int xPosition, int yPosition) {
        super(xPosition, yPosition, SPRITE, 20);
    }

    /**
     * Returns the speed of the projectile shot by the Crab.
     * 
     * @return An integer representing the speed of the Crab's projectile.
     */
    @Override
    public int getProjectileSpeed() {
        return 2;
    }
}
