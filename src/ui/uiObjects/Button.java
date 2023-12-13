package ui.uiObjects;

import ui.interfaces.Clickable;

abstract public class Button extends UIObject implements Clickable {
    private String text;

    public Button(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height);
        this.text = text;
    }

    @Override
    public void render() {
        viewController.drawText(text, x, y);
    }

    @Override
    abstract public void onClick();
}