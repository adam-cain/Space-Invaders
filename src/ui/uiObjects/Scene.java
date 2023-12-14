package ui.uiObjects;
import java.util.HashMap;
import java.util.Map;

import ui.interfaces.Clickable;

/**
 * The {@code Scene} class is an abstract base class for different scenes or screens in the Space Invaders game.
 * It manages a collection of UI objects such as buttons, labels, and other interactive elements. This class
 * handles the rendering and interaction logic for these UI elements.
 */
public abstract class Scene {
    protected Map<String, UIObject> uiObjects;

    /**
     * Constructs a new Scene with an empty collection of UI objects.
     */
    public Scene() {
        this.uiObjects = new HashMap<>();
    }

    /**
     * Adds a UI object to the scene.
     * 
     * @param uiObject the UI object to be added
     */
    public void addUIObject(UIObject uiObject) {
        uiObjects.put(uiObject.getName(), uiObject);
    }

    /**
     * Removes a UI object from the scene.
     * 
     * @param uiObject the UI object to be removed
     */
    public void removeUIObject(UIObject uiObject) {
        uiObjects.remove(uiObject.getName());
    }

    /**
     * Retrieves a UI object by its name.
     * 
     * @param name the name of the UI object
     * @return the UI object with the specified name, or null if not found
     */
    public UIObject getUIObject(String name) {
        return uiObjects.get(name);
    }

    /**
     * Handles click events on the scene. This method determines if a click event occurred
     * within a clickable UI object and, if so, triggers the object's click action.
     * 
     * @param x the x-coordinate of the click event
     * @param y the y-coordinate of the click event
     */
    public void handleClick(int x, int y) {
        for (UIObject uiObject : uiObjects.values()) {
            if (uiObject instanceof Clickable && uiObject.containsPoint(x, y)) {
                ((Clickable) uiObject).onClick();
                break;
            }
        }
    }

    /**
     * Renders all UI objects in the scene.
     */
    public void render() {
        for (UIObject uiObject : uiObjects.values()) {
            uiObject.render();
        }
    }

    /**
     * Abstract method for updating the scene. Subclasses should override this method
     * to define specific update behavior, such as responding to game state changes or
     * user input.
     *
     * @param args additional arguments that may be required for updating the scene
     */
    public abstract void update(Object... args);
}
