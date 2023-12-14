package ui.uiObjects;

import ui.ViewController;

/**
 * The {@code UIObject} class is an abstract base class for user interface elements in the Space Invaders game.
 * It defines common properties such as position, size, and a reference to the {@code ViewController} for rendering.
 * Subclasses of {@code UIObject} can represent various UI elements like buttons, labels, or images.
 */
public abstract class UIObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected ViewController viewController;
    protected String name;

    /**
     * Constructs a new {@code UIObject} with specified parameters.
     * 
     * @param name   the name of the UI object, used for identification
     * @param x      the x-coordinate of the object's top-left corner
     * @param y      the y-coordinate of the object's top-left corner
     * @param width  the width of the object
     * @param height the height of the object
     */
    public UIObject(String name, int x, int y, int width, int height) {
        this.viewController = ViewController.getInstance();
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if the given point (x, y) is within the bounds of this UI object.
     * 
     * @param x the x-coordinate of the point to check
     * @param y the y-coordinate of the point to check
     * @return {@code true} if the point is within the bounds of the object, {@code false} otherwise
     */
    public boolean containsPoint(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    /**
     * Gets the name of this UI object.
     * 
     * @return the name of the object
     */
    public String getName() {
        return name;
    }

    /**
     * Abstract method to render the UI object on the screen.
     * Subclasses should override this method to define their specific rendering behavior.
     */
    public abstract void render();
}
