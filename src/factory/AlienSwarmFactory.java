package factory;

import factory.types.AlienType;
import gameObjects.AlienObjects.Alien;
import gameObjects.AlienObjects.Crab;
import gameObjects.AlienObjects.Octopus;
import gameObjects.AlienObjects.Squid;

public class AlienSwarmFactory {
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