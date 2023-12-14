package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import gameObjects.BunkerObjects.Bunker;
import handler.SoundHandler.SoundManager;
import handler.SoundHandler.Sound;

public class BunkerCollisionHandler extends CollisionHandler {

    public BunkerCollisionHandler(Game game) {
        super(game);
    }

    @Override
    public boolean handleRequest(CollisionPair input) {
        if(input.getCollidable() instanceof Bunker){
            SoundManager.playSound(Sound.EXPLOSION);
            Bunker bunker = (Bunker) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if(bunker.checkCollisions(projectile)){
                removeProjectile(projectile);
                return true;
            }
        }
        else if(getNext() != null){
            return getNext().handleRequest(input);
        }
        return false;
    }
    
}
