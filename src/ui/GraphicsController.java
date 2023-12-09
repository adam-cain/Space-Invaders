package ui;
import java.awt.Dimension;

import util.Image;

public class GraphicsController {
    private static GraphicsController instance;

    public static GraphicsController getInstance() {
        if (instance == null) {
            instance = new GraphicsController();
        }
        return instance;
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

    public Dimension getWindowSize() {
        // Stub implementation returning a fixed window size
        return new Dimension(800, 600); // Example size: 800 width x 600 height
    }
}
