package handler.CollisionHandlers;

import gameObjects.Projectile;
import interfaces.Collidable;

public class CollisionPair{
    private Projectile projectile;
    private Collidable collidable;

    public CollisionPair(Projectile projectile, Collidable collidable){
        this.projectile = projectile;
        this.collidable = collidable;
    }

    public Projectile getProjectile(){
        return this.projectile;
    }

    public Collidable getCollidable(){
        return this.collidable;
    }
}
