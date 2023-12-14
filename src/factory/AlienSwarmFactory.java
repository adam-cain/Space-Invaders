package factory;

import factory.types.AlienType;
import gameObjects.AlienObjects.Alien;
import gameObjects.AlienObjects.Crab;
import gameObjects.AlienObjects.Octopus;
import gameObjects.AlienObjects.Squid;

/**
 * Factory class for creating instances of different types of aliens.
 */
public class AlienSwarmFactory {
    /**
     * Creates an alien object of the specified type at the given position.
     * 
     * @param type      The type of the alien to be created, as specified by the
     *                  AlienType enum.
     * @param xPosition The x-coordinate where the alien will be placed.
     * @param yPosition The y-coordinate where the alien will be placed.
     * @return An instance of the specified Alien type.
     * @throws IllegalArgumentException If the specified alien type is not recognized.
     */
    public static Alien createAlien(AlienType type, int xPosition, int yPosition) {
        switch (type) {
            case SQUID:
                return new Squid(xPosition, yPosition);
            case CRAB:
                return new Crab(xPosition, yPosition);
            case OCTOPUS:
                return new Octopus(xPosition, yPosition);
            default:
                throw new IllegalArgumentException("Invalid alien type: " + type);
        }
    }
}