package ui.uiObjects;

import interfaces.Clickable;

public class Button extends UIObject implements Clickable {
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
    public void onClick() {
        // Handle button click event
    }

    // Add more methods specific to Button class
}