package gameObjects; // Update this to match your new package structure

import gameObjects.ProjectileObjects.ProjectileBehaviour.UpwardProjectileBehavior;
import interfaces.Moving;
import interfaces.ProjectileBehavior;
import interfaces.Shooting;
import util.Image;
public class Player extends GameObject implements Moving, Shooting{
    private static Image sprite = new Image("src/assets/player.png", 40, 40);
    private int moveSpeed = 5;
    private int lives = 3;

    public Player() {
        super(0, -50, sprite);
    }

    public void moveLeft() {
        translate(-1 * moveSpeed, 0);
    }

    public void moveRight() {
        translate(moveSpeed, 0);
    }

    public boolean isAlive() {
        if (lives > 0) {
            return true;
        }
        return false;
    }

    @Override
    public int getProjectileSpeed() {
        return 3;
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
    public ProjectileBehavior getProjectileBehavior() {
        return new UpwardProjectileBehavior();
    }

    @Override
    public Image getSprite() {
        return new Image("src/assets/playerProjectile.png", 10, 40);
    }
}
