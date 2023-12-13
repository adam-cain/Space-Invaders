package ui.uiObjects;

import ui.ViewController;

public abstract class UIObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected ViewController viewController;
    protected String name;

    public UIObject(String name, int x, int y, int width, int height) {
        viewController = ViewController.getInstance();
        this.name = name;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean containsPoint(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    public String getName() {
        return name;
    }

    public abstract void render();
}