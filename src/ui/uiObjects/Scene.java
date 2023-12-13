package ui.uiObjects;
import java.util.HashMap;
import java.util.Map;

import ui.interfaces.Clickable;

public abstract class Scene {
    protected Map<String, UIObject> uiObjects;

    public Scene() {
        this.uiObjects = new HashMap<>();
    }

    public void addUIObject(UIObject uiObject) {
        uiObjects.put(uiObject.getName(), uiObject);
    }

    public void removeUIObject(UIObject uiObject) {
        uiObjects.remove(uiObject.getName());
    }

    public UIObject getUIObject(String name) {
        return uiObjects.get(name);
    }

    public void handleClick(int x, int y) {
        for (UIObject uiObject : uiObjects.values()) {
            if (uiObject instanceof Clickable && uiObject.containsPoint(x, y)) {
                ((Clickable) uiObject).onClick();
                break;
            }
        }
    }

    public void render() {
        for (UIObject uiObject : uiObjects.values()) {
            uiObject.render();
        }
    }

    public abstract void update(Object... args);
}