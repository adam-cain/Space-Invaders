package ui.uiObjects;

/**
 * The {@code Label} class represents a non-interactive text display element in the Space Invaders game.
 * This class extends {@code UIObject} and is used to display text on the screen, such as scores, titles,
 * or any other informational text. The position and size of the label can be specified, along with the text content.
 */
public class Label extends UIObject {
    private String text;

    /**
     * Constructs a new {@code Label} with specified parameters.
     *
     * @param name   the name of the label, used for identification
     * @param x      the x-coordinate of the label's top-left corner
     * @param y      the y-coordinate of the label's top-left corner
     * @param width  the width of the label; may be used for alignment purposes
     * @param height the height of the label; may be used for alignment purposes
     * @param text   the text content of the label
     */
    public Label(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height);
        this.text = text;
    }

    /**
     * Renders the label on the screen. This method displays the label's text
     * at its specified location.
     */
    @Override
    public void render() {
        viewController.drawText(text, x, y);
    }

    /**
     * Sets the text content of the label. This method can be used to update the text
     * displayed by the label.
     *
     * @param text the new text to be displayed on the label
     */
    public void setText(String text) {
        this.text = text;
    }
}
