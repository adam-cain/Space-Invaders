package interfaces;

import core.Game;
import factory.GameObjectFactory;
import gameObjects.GameObject;
import gameObjects.Projectile;
import util.Image;

public interface Shooting extends Collidable{
    int getProjectileSpeed();
    GameObject getThis();
    MovementBehavior getProjectileBehavior();
    Image getProjectileSprite();
    default public void shoot() {
        if(getProjectileSpeed() > 0){
            Projectile projectile = GameObjectFactory.createProjectile(getY(), getX(), getProjectileSpeed(), getProjectileBehavior(), getProjectileSprite(), getThis());
            Game game = Game.getInstance();
            game.addProjectile(projectile);
        }
    }
}