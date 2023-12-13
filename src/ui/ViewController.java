package ui;

import java.awt.Dimension;

import handler.InputHandlers.KeyCode;
import ui.uiObjects.*;
import util.Image;
import java.util.Random;

public class ViewController {
    private static ViewController instance;
    private Scene scene;

    private ViewController() {
    }

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    public void handleClick(int x, int y) {
        if (scene != null) {
            scene.handleClick(x, y);
        }
    }

    public void loadScene(Scene scene) {
        this.scene = scene;
    }

    public void drawImage(Image image, int x, int y) {
        // Draw image at coordinates
    }

    public void drawText(String text, int x, int y) {
        // Draw text at coordinates
    }

    public void clear() {
        // Clear screen
    }

    static public Dimension getWindowSize() {
        // Stub implementation returning a fixed window size
        // Example size: 800 width x 600 height
        return new Dimension(800, 600);
    }

    public KeyCode getKeyPressed() {
        // Stub implementation for getting key press from users.
        // Returns a random keycode with higher chance of returning null
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

    public void handleMouseClick(){
        // Stub implementation for handling mouse click
        Dimension windowsSize = getWindowSize();
        int x = new Random().nextInt(windowsSize.width);
        int y = new Random().nextInt(windowsSize.height);
        scene.handleClick(x, y);
    }
}
