package factory;

import factory.types.ProjectileType;
import gameObjects.Projectile;

public class ProjectileFactory {
    public static Projectile createAlien(ProjectileType type, int xPosition, int yPosition) {
        if (type == ProjectileType.PLAYER_PROJECTILE) {
            return new Squid(xPosition, yPosition);
        } else if (type == ProjectileType.ALIEN_PROJECTILE) {
            return new Crab(xPosition, yPosition);
        } else {
            throw new IllegalArgumentException("Invalid alien type: " + type);
        }
    }
}
