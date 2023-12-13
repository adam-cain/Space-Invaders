package handler.CollisionHandlers;

import core.Game;
import gameObjects.Projectile;
import interfaces.Handler;

public abstract class CollisionHandler implements Handler<CollisionPair> {

    protected Game game;
    private Handler<CollisionPair> next;

    public CollisionHandler(Game game) {
        this.game = game;
    }

    @Override
    public Handler<CollisionPair> getNext() {
        return next;
    }

    @Override
    public void setNext(Handler<CollisionPair> next) {
        this.next = next;
    }

    protected void removeProjectile(Projectile projectile) {
        game.removeProjectile(projectile);
    }

    @Override
    public abstract boolean handleRequest(CollisionPair input); 
}
