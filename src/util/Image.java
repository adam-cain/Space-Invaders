package util;
import java.awt.Dimension; 

/**
 * The {@code Image} class represents an image resource in the Space Invaders game.
 * It stores information about the image such as its source path, width, and height.
 * This class is used to manage and access image data for rendering in the game's UI.
 */
public class Image {
    private String src;
    private int width;
    private int height;

    /**
     * Constructs a new {@code Image} with the specified source path and dimensions.
     * 
     * @param src    the source path of the image file
     * @param width  the width of the image in pixels
     * @param height the height of the image in pixels
     */
    public Image(String src, int width, int height) {
        this.src = src;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets the source path of the image.
     * 
     * @return the source path of the image
     */
    public String getSrc() {
        return src;
    }

    /**
     * Gets the size of the image as a {@code Dimension} object.
     * 
     * @return the dimensions of the image
     */
    public Dimension getSize() {
        return new Dimension(width, height);
    }
}
