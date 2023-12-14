package gameObjects.AlienObjects;

import util.Image;

/**
 * Represents an 'Octopus' type alien in the game.
 * This class extends ShootingAlien, providing specific functionality for the Octopus alien.
 */
public class Octopus extends ShootingAlien {
    private static final Image SPRITE = new Image("src/assets/octopus.png", 40, 40);

    /**
     * Constructs a new Octopus alien with specified position coordinates.
     * 
     * @param xPosition The x-coordinate of the Octopus's initial position.
     * @param yPosition The y-coordinate of the Octopus's initial position.
     */
    public Octopus(int xPosition, int yPosition) {
        super(xPosition, yPosition, SPRITE, 10);
    }

    /**
     * Returns the speed of the projectile shot by the Octopus.
     * 
     * @return An integer representing the speed of the Octopus's projectile.
     */
    @Override
    public int getProjectileSpeed() {
        return 1;
    }
}
