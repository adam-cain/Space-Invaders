package gameObjects; // Update this to match your new package structure

import java.awt.Dimension;

import gameObjects.MovementBehavior.LinearUp;
import interfaces.Moving;
import interfaces.MovementBehavior;
import interfaces.Shooting;
import ui.ViewController;
import util.Image;
public class Player extends GameObject implements Moving, Shooting{
    private static final Image SPRITE = new Image("src/assets/player.png", 40, 40);
    private static final int MOVE_SPEED = 5;
    private static final Image PROJECTILE_SPRITE = new Image("src/assets/playerProjectile.png", 10, 40);
    private static final int PROJECTILE_SPEED = 3;

    private int lives = 3;
    public Player() {
        super(0, -50, SPRITE);
    }

    public void resetPosition() {
        Dimension windowSize = ViewController.getWindowSize();
        int x = (int) (windowSize.width / 2 - getWidth() / 2);
        int deltaX = x - getX();
        translate(deltaX, 0);
    }

    public void moveLeft() {
        if (getX() - MOVE_SPEED > 0) {
            translate(-MOVE_SPEED, 0);
        }
    }

    public void moveRight() {
        Dimension windowSize = ViewController.getWindowSize();
        if (getX() + MOVE_SPEED + getWidth() < windowSize.width) {
            translate(MOVE_SPEED, 0);
        }
    }

    public boolean isAlive() {
        return lives > 0;
    }

    @Override
    public int getProjectileSpeed() {
        return PROJECTILE_SPEED;
    }

    @Override
    public GameObject getThis() {
        return this;
    }

    @Override
    public void handleCollision() {
        lives--;
    }

    @Override
    public MovementBehavior getProjectileBehavior() {
        return new LinearUp();
    }

    @Override
    public Image getProjectileSprite() {
        return PROJECTILE_SPRITE;
    }
}