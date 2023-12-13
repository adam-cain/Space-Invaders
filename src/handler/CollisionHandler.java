package handler;

import gameObjects.Projectile;
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

public abstract class CollisionHandler implements Handler<CollisionPair> {
    private Handler<CollisionPair> next;

    public CollisionHandler() {
    }
    
    @Override
    public void setNext(Handler<CollisionPair> next) {
        this.next = next;
    }

    @Override
    public Handler<CollisionPair> getNext() {
        return next;
    }
}

