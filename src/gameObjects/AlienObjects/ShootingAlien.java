package gameObjects.AlienObjects;

import gameObjects.GameObject;
import interfaces.Shootable;
import util.Image;
import util.ProjectileDirection;

public abstract class ShootingAlien extends Alien implements Shootable{
    public ShootingAlien(int xPosition, int yPosition, Image sprite, int points) {
        super(xPosition, yPosition, sprite, points);
    }

    @Override
    public ProjectileDirection getProjectileDirection(){
        return ProjectileDirection.DOWN;
    }

    @Override
    public GameObject getThis(){
        return this;
    }
}
