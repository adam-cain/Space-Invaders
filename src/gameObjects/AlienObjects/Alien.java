package gameObjects.AlienObjects;

import gameObjects.GameObject;
import interfaces.Collidable;
import interfaces.Movable;
import util.Image;

public abstract class Alien extends GameObject implements Movable, Collidable{
    protected int points;
    protected boolean isAlive;


    public Alien(int xPosition, int yPosition, Image sprite, int points) {
        super(xPosition, yPosition, sprite);
        this.points = points;
        this.isAlive = true;
    }

    public void hit() {
        this.isAlive = false;
    }

    public int getPoints() {
        return points;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
