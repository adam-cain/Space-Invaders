package gameObjects;

import java.awt.Dimension;

import gameObjects.MovementBehavior.LinearUp;
import interfaces.Moving;
import interfaces.MovementBehavior;
import interfaces.Shooting;
import ui.ViewController;
import util.Image;

/**
 * Represents a player in the game, including its properties and behaviors.
 * This class is responsible for managing the player's movements, projectiles, and lives.
 */
public class Player extends GameObject implements Moving, Shooting {
    private static final Image SPRITE = new Image("src/assets/player.png", 40, 40);
    private static final int MOVE_SPEED = 5;
    private static final Image PROJECTILE_SPRITE = new Image("src/assets/playerProjectile.png", 10, 40);
    private static final int PROJECTILE_SPEED = 3;

    private int lives = 3;

    /**
     * Constructs a new Player object with initial position and sprite.
     */
    public Player() {
        super(0, -50, SPRITE);
    }

    /**
     * Resets the player's position to the center of the window.
     */
    public void resetPosition() {
        Dimension windowSize = ViewController.getWindowSize();
        int x = (int) (windowSize.width / 2 - getWidth() / 2);
        int deltaX = x - getX();
        translate(deltaX, 0);
    }

    /**
     * Moves the player to the left if within window bounds.
     */
    public void moveLeft() {
        if (getX() - MOVE_SPEED > 0) {
            translate(-MOVE_SPEED, 0);
        }
    }

    /**
     * Moves the player to the right if within window bounds.
     */
    public void moveRight() {
        Dimension windowSize = ViewController.getWindowSize();
        if (getX() + MOVE_SPEED + getWidth() < windowSize.width) {
            translate(MOVE_SPEED, 0);
        }
    }

    /**
     * Checks if the player is still alive (i.e., has remaining lives).
     *
     * @return true if the player has more than 0 lives, false otherwise.
     */
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

    /**
     * Handles the collision event by decrementing the player's lives.
     */
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
