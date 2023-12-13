package gameObjects;

import java.awt.Dimension;

import interfaces.Moving;
import interfaces.MovementBehavior;
import ui.ViewController;
import util.Image;

public class Projectile extends GameObject implements Moving {

    private MovementBehavior behavior;
    private GameObject shooter;
    private int projectileSpeed;

    public Projectile(int xPosition, int yPosition, MovementBehavior behavior, int projectileSpeed, Image sprite, GameObject shooter) {
        super(xPosition, yPosition, sprite);
        this.behavior = behavior;
        this.shooter = shooter;
        this.projectileSpeed = projectileSpeed;
    }

    public void update() {
        behavior.execute(this, projectileSpeed);
    }

    public GameObject getShooter() {
        return shooter;
    }

    public boolean isOutOfBounds() {
        Dimension windowSize = ViewController.getWindowSize();
        return getX() < 0 || getX() > windowSize.getWidth() || getY() < 0 || getY() > windowSize.getHeight();
    }
}