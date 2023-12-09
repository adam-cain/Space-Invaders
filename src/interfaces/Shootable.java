package interfaces;

import gameObjects.Projectile;
import gameObjects.GameObject;
import util.ProjectileDirection;

public interface Shootable extends Collidable{
    int getProjectileSpeed();
    ProjectileDirection getProjectileDirection();
    GameObject getThis();
    default public Projectile shoot() {
        if(getProjectileSpeed() > 0){
            return new Projectile(getX(), getY(), getProjectileSpeed() ,getProjectileDirection(), getThis());
        }
        return null;
    }
}