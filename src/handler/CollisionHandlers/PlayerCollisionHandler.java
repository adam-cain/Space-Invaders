package handler.CollisionHandlers;

import core.Game;
import gameObjects.Player;
import gameObjects.Projectile;
import handler.SoundHandler.Sound;
import handler.SoundHandler.SoundManager;

/**
 * Handles collisions specifically for Player objects in the game.
 * This class is responsible for detecting and responding to collisions involving Players.
 */
public class PlayerCollisionHandler extends CollisionHandler {

    /**
     * Constructs a new PlayerCollisionHandler.
     *
     * @param game The game instance this handler is associated with.
     */
    public PlayerCollisionHandler(Game game) {
        super(game);
    }

    /**
     * Handles collision requests involving Player objects.
     * If a Player collides with a Projectile, this method plays a sound, removes a life from the player, 
     * resets the player's position, and updates the game state.
     *
     * @param input The CollisionPair containing the objects involved in the collision.
     * @return true if the collision was handled, false otherwise.
     */
    @Override
    public boolean handleRequest(CollisionPair input) {
        if (input.getCollidable() instanceof Player) {
            Player player = (Player) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if (player.collides(projectile)) {
                SoundManager.playSound(Sound.EXPLOSION);
                game.removeLife();
                player.resetPosition();
                removeProjectile(projectile);
                return true;
            }
        } else if (getNext() != null) {
            return getNext().handleRequest(input);
        }
        return false;
    }
}
