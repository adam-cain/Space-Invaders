package gameObjects;

import interfaces.Positionable;
import ui.ViewController;
import util.Image;

/**
 * Abstract class representing a game object.
 * This class provides the basic framework for objects within the game, including position and sprite management.
 */
public abstract class GameObject implements Positionable {
    private int x, y;
    private final double width, height;
    private final Image sprite;

    /**
     * Constructor for GameObject.
     * Initializes the game object with a position and sprite.
     *
     * @param x The initial x-coordinate of the game object.
     * @param y The initial y-coordinate of the game object.
     * @param sprite The image representing the game object.
     */
    public GameObject(int x, int y, Image sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;
        this.width = sprite.getSize().getWidth();
        this.height = sprite.getSize().getHeight();
    }

    /**
     * Sets the x-coordinate of the game object.
     *
     * @param x The new x-coordinate.
     */
    @Override
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Sets the y-coordinate of the game object.
     *
     * @param y The new y-coordinate.
     */
    @Override
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Gets the x-coordinate of the game object.
     *
     * @return The current x-coordinate.
     */
    @Override
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate of the game object.
     *
     * @return The current y-coordinate.
     */
    @Override
    public int getY() {
        return this.y;
    }

    /**
     * Gets the width of the game object.
     *
     * @return The width of the game object.
     */
    @Override
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets the height of the game object.
     *
     * @return The height of the game object.
     */
    @Override
    public double getHeight() {
        return this.height;
    }

    /**
     * Draws the game object using its sprite at its current position.
     * Delegates the actual drawing to the ViewController.
     */
    public void draw() {
        ViewController.getInstance().drawImage(sprite, x, y);
    }
}
