package ui.uiObjects;

import util.Image;

/**
 * The {@code UIImage} class represents an image-based UI element in the Space Invaders game.
 * This class extends {@code UIObject} and is used to display images on the screen. It can be
 * used for various purposes such as displaying background images, icons, or other graphical elements.
 */
public class UIImage extends UIObject {
    private Image image;

    /**
     * Constructs a new {@code UIImage} with the specified parameters.
     * 
     * @param name the name of the image UI object, used for identification
     * @param x    the x-coordinate of the image's top-left corner
     * @param y    the y-coordinate of the image's top-left corner
     * @param image the {@code Image} object to be displayed
     */
    public UIImage(String name, int x, int y, Image image) {
        super(name, x, y, image.getSize().width, image.getSize().height);
        this.image = image;
    }

    /**
     * Renders the image on the screen. This method displays the image at its specified
     * location. The dimensions of the image are determined by the {@code Image} object.
     */
    @Override
    public void render() {
        viewController.drawImage(image, x, y);
    }
}
