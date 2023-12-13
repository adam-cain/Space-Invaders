package ui.uiObjects;

import util.Image;

public class UIImage extends UIObject {
    private Image image;

    public UIImage(String name, int x, int y, Image image) {
        super(name, x, y, image.getSize().width, image.getSize().height);
        this.image = image;
    }

    @Override
    public void render() {
        viewController.drawImage(image, x, y);
    }
}
