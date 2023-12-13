package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import gameObjects.AlienObjects.Alien;

public class AlienCollisionHandler extends CollisionHandler {

    public AlienCollisionHandler(Game game) {
        super(game);
    }

    @Override
    public boolean handleRequest(CollisionPair input) {
        if(input.getCollidable() instanceof Alien){
            Alien alien = (Alien) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if(alien.collides(projectile)){
                game.addPoints(alien.getPoints());
                alien.hit();
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
