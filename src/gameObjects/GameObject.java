package gameObjects;

import java.awt.Dimension;

import interfaces.Positionable;
import ui.ViewController;
import util.Image;

public abstract class GameObject implements Positionable {
    private int x, y;
    private final double width, height;
    private final Image sprite;

    public GameObject(int x, int y, Image sprite) {
        this.x = x;
        this.y = y;
        this.sprite = sprite;

        // Directly initialize width and height
        this.width = sprite.getSize().getWidth();
        this.height = sprite.getSize().getHeight();
    }

    // Position setters and getters
    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    // Size getters
    @Override
    public double getWidth() {
        return this.width;
    }

    @Override
    public double getHeight() {
        return this.height;
    }

    public void draw() {
        ViewController.getInstance().drawImage(sprite, x, y);
    }
}
