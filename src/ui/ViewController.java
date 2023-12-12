package ui;

import java.awt.Dimension;
import ui.uiObjects.*;
import util.Image;

public class ViewController {
    private static ViewController instance;
    private Scene scene;

    private ViewController() {}

    public static ViewController getInstance() {
        if (instance == null) {
            instance = new ViewController();
        }
        return instance;
    }

    public void handleClick(int x, int y) {
        if(scene != null) {
            scene.handleClick(x, y);
        }
    }

    public void loadScene(Scene scene) {
        this.scene = scene;
    }

    public void drawImage(Image image, int x, int y) {
        //Draw image at coordinates
    }

    public void drawText(String text, int x, int y) {
        //Draw text at coordinates
    }

    public void clear() {
        //Clear screen
    }

    static public Dimension getWindowSize() {
        // Stub implementation returning a fixed window size
        return new Dimension(800, 600); // Example size: 800 width x 600 height
    }
}
