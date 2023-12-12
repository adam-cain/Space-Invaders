package ui.uiObjects;

public class Label extends UIObject {
    private String text;

    public Label(String name, int x, int y, int width, int height, String text) {
        super(name, x, y, width, height);
        this.text = text;
    }

    @Override
    public void render() {
        viewController.drawText(text, x, y);
    }

    public void setText(String text) {
        this.text = text;
    }
}