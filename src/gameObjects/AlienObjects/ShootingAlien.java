package gameObjects.AlienObjects;

import gameObjects.GameObject;
import gameObjects.MovementBehavior.LinearDown;
import interfaces.MovementBehavior;
import interfaces.Shooting;
import util.Image;

public abstract class ShootingAlien extends Alien implements Shooting{
    public ShootingAlien(int xPosition, int yPosition, Image sprite, int points) {
        super(xPosition, yPosition, sprite, points);
    }

    @Override
    public GameObject getThis(){
        return this;
    }

    @Override
    public MovementBehavior getProjectileBehavior() {
        return new LinearDown();
    }

    @Override
    public Image getProjectileSprite() {
        return new Image("src/assets/alienProjectile.png", 10, 40);
    }
}
