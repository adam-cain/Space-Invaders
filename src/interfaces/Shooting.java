package interfaces;

import core.Game;
import factory.GameObjectFactory;
import gameObjects.GameObject;
import gameObjects.Projectile;
import handler.SoundHandler.Sound;
import handler.SoundHandler.SoundManager;
import util.Image;

public interface Shooting extends Collidable{
    int getProjectileSpeed();
    GameObject getThis();
    MovementBehavior getProjectileBehavior();
    Image getProjectileSprite();
    default public void shoot() {
        if(getProjectileSpeed() > 0){
            SoundManager.playSound(Sound.SHOOT);
            Projectile projectile = GameObjectFactory.createProjectile(getY(), getX(), getProjectileSpeed(), getProjectileBehavior(), getProjectileSprite(), getThis());
            Game game = Game.getInstance();
            game.addProjectile(projectile);
        }
    }
}