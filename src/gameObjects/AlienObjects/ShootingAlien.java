package gameObjects.AlienObjects;

import gameObjects.GameObject;
import gameObjects.ProjectileObjects.ProjectileBehaviour.DownwardProjectileBehavior;
import interfaces.ProjectileBehavior;
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
    public ProjectileBehavior getProjectileBehavior() {
        return new DownwardProjectileBehavior();
    }

    @Override
    public Image getSprite() {
        return new Image("src/assets/alienProjectile.png", 10, 40);
    }
}
