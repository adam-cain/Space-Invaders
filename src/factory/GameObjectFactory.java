package factory;

import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.BunkerObjects.Bunker;
import gameObjects.BunkerObjects.BunkerShapes.BunkerShape;
import gameObjects.ProjectileObjects.Projectile;
import interfaces.ProjectileBehavior;
import util.Image;

public class GameObjectFactory {
    public static Player createPlayer() {
        return new Player();
    }

    public static Projectile createProjectile(int xPosition, int yPosition, int projectileSpeed, ProjectileBehavior behavior, Image sprite, GameObject shooter) {
        return new Projectile(xPosition, yPosition, behavior, projectileSpeed, sprite, shooter);
    }

    public static Bunker createBunker(int xPosition, int yPosition, BunkerShape bunkerShape) {
        return new Bunker(xPosition, yPosition, bunkerShape);
    }
}

