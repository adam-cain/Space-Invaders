package factory;

import gameObjects.GameObject;
import gameObjects.Player;
import gameObjects.Projectile;
import gameObjects.AlienObjects.UFO;
import gameObjects.BunkerObjects.Bunker;
import gameObjects.BunkerObjects.BunkerShapes.BunkerShape;
import interfaces.MovementBehavior;
import util.Image;

/**
 * Factory class for creating instances of various game objects.
 */
public class GameObjectFactory {

    /**
     * Creates a new Player object.
     *
     * @return A new instance of Player.
     */
    public static Player createPlayer() {
        return new Player();
    }

    /**
     * Creates a new Projectile object with specified attributes.
     *
     * @param xPosition       The x-coordinate of the projectile.
     * @param yPosition       The y-coordinate of the projectile.
     * @param projectileSpeed The speed of the projectile.
     * @param behavior        The movement behavior of the projectile.
     * @param sprite          The image representing the projectile.
     * @param shooter         The game object that shot the projectile.
     * @return A new instance of Projectile.
     */
    public static Projectile createProjectile(int xPosition, int yPosition, int projectileSpeed, MovementBehavior behavior, Image sprite, GameObject shooter) {
        return new Projectile(xPosition, yPosition, behavior, projectileSpeed, sprite, shooter);
    }

    /**
     * Creates a new Bunker object with a specified position and shape.
     *
     * @param xPosition   The x-coordinate of the bunker.
     * @param yPosition   The y-coordinate of the bunker.
     * @param bunkerShape The shape of the bunker.
     * @return A new instance of Bunker.
     */
    public static Bunker createBunker(int xPosition, int yPosition, BunkerShape bunkerShape) {
        return new Bunker(xPosition, yPosition, bunkerShape);
    }

    /**
     * Creates a new UFO object with a specified speed.
     *
     * @param speed The speed of the UFO.
     * @return A new instance of UFO.
     */
    public static UFO createUFO(int speed) {
        return new UFO(speed);
    }
}
