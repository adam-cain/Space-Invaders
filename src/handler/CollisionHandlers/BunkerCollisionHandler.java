package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import gameObjects.BunkerObjects.Bunker;

public class BunkerCollisionHandler extends CollisionHandler {

    public BunkerCollisionHandler(Game game) {
        super(game);
    }

    @Override
    public void handleRequest(CollisionPair input) {
        if(input.getCollidable() instanceof Bunker){
            Bunker bunker = (Bunker) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if(bunker.checkCollisions(projectile)){
                removeProjectile(projectile);
            }
        }
        else if(getNext() != null){
            getNext().handleRequest(input);
        }
    }
    
}
