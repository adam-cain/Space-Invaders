package ui.uiObjects;

import ui.interfaces.Clickable;

/**
 * Abstract class {@code Button} represents a clickable button UI element in the Space Invaders game.
 * This class extends {@code UIObject} and implements the {@code Clickable} interface, indicating
 * it can be interacted with via clicking. A {@code Button} contains text and is capable of rendering
 * itself on the screen and responding to click events.
 */
abstract public class Button extends UIObject implements Clickable {
    private String text;

    /**
     * Constructs a new {@code UIObject} with the specified parameters.
     * 
     * @param name   the name of the button, used for identification
     * @param x      the x-coordinate of the button's top-left corner
     * @param y      the y-coordinate of the button's top-left corner
     * @param width  the width of the button
     * @param height the height of the button
     * @param text   the text to be displayed on the button
     */
    public Button(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height);
        this.text = text;
    }

    /**
     * Renders the button on the screen. This method will display the button's text
     * at its specified location.
     */
    @Override
    public void render() {
        viewController.drawText(text, x, y);
    }

    /**
     * Abstract method to be implemented by subclasses to define the action to be taken
     * when the button is clicked. This method allows for different buttons to have different
     * behaviors upon being clicked.
     */
    @Override
    abstract public void onClick();
}
