package interfaces;

import core.Game;
import factory.GameObjectFactory;
import gameObjects.GameObject;
import gameObjects.ProjectileObjects.Projectile;
import util.Image;

public interface Shooting extends Collidable{
    int getProjectileSpeed();
    GameObject getThis();
    ProjectileBehavior getProjectileBehavior();
    Image getSprite();
    default public void shoot() {
        if(getProjectileSpeed() > 0){
            Projectile projectile = GameObjectFactory.createProjectile(getY(), getX(), getProjectileSpeed(), getProjectileBehavior(), getSprite(), getThis());
            Game game = Game.getInstance();
            game.addProjectile(projectile);
        }
    }
}