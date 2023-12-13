package handler.CollisionHandlers;

import core.Game;
import gameObjects.Player;
import gameObjects.Projectile;

public class PlayerCollisionHandler extends CollisionHandler{
    
    public PlayerCollisionHandler(Game game) {
        super(game);
    }

     @Override
    public void handleRequest(CollisionPair input) {
        if(input.getCollidable() instanceof Player){
            Player player = (Player) input.getCollidable();
            Projectile projectile = input.getProjectile();
            if(player.collides(projectile)){
                game.removeLife();
                player.resetPosition();
                removeProjectile(projectile);
            }
        }
        else if(getNext() != null){
            getNext().handleRequest(input);
        }
    }
}