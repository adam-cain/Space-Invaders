package ui;

import java.awt.Dimension;
import handler.InputHandlers.KeyCode;
import ui.uiObjects.*;
import util.Image;
import java.util.Random;

/**
 * The {@code ViewController} class acts as a central controller for UI rendering and input handling in the Space Invaders game.
 * It follows the Singleton design pattern to ensure a single shared instance is used throughout the game.
 * This class manages the current scene, handles mouse and keyboard inputs, and provides methods for drawing images and text.
 */
public class ViewController {
    private static ViewController instance;
    private Scene scene;

    private ViewController() {
    }

    /**
     * Gets the singleton instance of the {@code ViewController}.
     * 
     * @return the singleton instance of {@code ViewController}
     */
    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    /**
     * Handles mouse click events by delegating to the current scene.
     * 
     * @param x the x-coordinate of the mouse click
     * @param y the y-coordinate of the mouse click
     */
    public void handleClick(int x, int y) {
        if (scene != null) {
            scene.handleClick(x, y);
        }
    }

    /**
     * Loads a new scene into the view controller.
     * 
     * @param scene the scene to be loaded
     */
    public void loadScene(Scene scene) {
        this.scene = scene;
    }

    /**
     * Draws an image at specified coordinates.
     * 
     * @param image the image to be drawn
     * @param x     the x-coordinate where the image will be drawn
     * @param y     the y-coordinate where the image will be drawn
     */
    public void drawImage(Image image, int x, int y) {
        // Draw image at coordinates
    }

    /**
     * Draws text at specified coordinates.
     * 
     * @param text the text to be drawn
     * @param x    the x-coordinate where the text will be drawn
     * @param y    the y-coordinate where the text will be drawn
     */
    public void drawText(String text, int x, int y) {
        // Draw text at coordinates
    }

    /**
     * Clears the screen.
     */
    public void clear() {
        // Clear screen
    }

    /**
     * Gets the size of the game window.
     * 
     * @return the dimensions of the game window
     */
    static public Dimension getWindowSize() {
        // Stub implementation returning a fixed window size
        return new Dimension(800, 600);
    }

    /**
     * Gets the last key pressed by the user.
     * 
     * @return the {@code KeyCode} of the last key pressed, or null if no key was pressed
     */
    public KeyCode getKeyPressed() {
        // Stub implementation for getting key press from users
        Random random = new Random();
        int randomValue = random.nextInt(20); 
        switch (randomValue) {
            case 0:
                return KeyCode.A;
            case 1:
                return KeyCode.ARROW_LEFT;
            case 2:
                return KeyCode.D;
            case 3:
                return KeyCode.ARROW_RIGHT;
            case 4:
                return KeyCode.SPACE;
            default:
                return null;
        }
    }

    /**
     * Simulates handling a mouse click by generating a random click position and delegating to the current scene.
     */
    public void handleMouseClick() {
        // Stub implementation for handling mouse click
        Dimension windowsSize = getWindowSize();
        int x = new Random().nextInt(windowsSize.width);
        int y = new Random().nextInt(windowsSize.height);
        scene.handleClick(x, y);
    }
}
