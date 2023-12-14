package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import gameObjects.AlienObjects.Alien;
import handler.SoundHandler.Sound;
import handler.SoundHandler.SoundManager;

/**
 * Handles collisions specifically for Alien objects in the game.
 * This class is responsible for detecting and responding to collisions involving Aliens.
 */
public class AlienCollisionHandler extends CollisionHandler {

    /**
     * Constructs a new AlienCollisionHandler.
     *
     * @param game The game instance this handler is associated with.
     */
    public AlienCollisionHandler(Game game) {
        super(game);
    }

    /**
     * Handles collision requests involving Alien objects. 
     * If an Alien collides with a Projectile, this method plays a sound, awards points, and updates the game state.
     *
     * @param input The CollisionPair containing the objects involved in the collision.
     * @return true if the collision was handled, false otherwise.
     */
    @Override
    public boolean handleRequest(CollisionPair input) {
        if (input.getCollidable() instanceof Alien) {
            Alien alien = (Alien) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if (alien.collides(projectile)) {
                SoundManager.playSound(Sound.EXPLOSION);
                game.addPoints(alien.getPoints());
                alien.hit();
                removeProjectile(projectile);
                return true;
            }
        } else if (getNext() != null) {
            return getNext().handleRequest(input);
        }
        return false;
    }
}
