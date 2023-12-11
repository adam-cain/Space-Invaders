package handler;

import gameObjects.ProjectileObjects.Projectile;
import interfaces.Collidable;
import interfaces.Handler;

class CollisionPair {
    private Projectile projectile;
    private Collidable object2;

    public CollisionPair(Projectile projectile, Collidable object2) {
        this.projectile = projectile;
        this.object2 = object2;
    }
}

public class CollisionHandler implements Handler<CollisionPair> {
    private Handler<CollisionPair> next;
    
    @Override
    public void setNext(Handler<CollisionPair> next) {
        this.next = next;
    }

    @Override
    public boolean handleInput(CollisionPair input) {
        // Handle the collision
        return true;
    }

    @Override
    public Handler<CollisionPair> getNext() {
        return next;
    }
}

