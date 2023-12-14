package ui.interfaces;

/**
 * The {@code ClickListener} interface is intended for objects that need to respond to click events.
 * In the context of the Space Invaders game, this interface can be implemented by UI elements
 * or game objects that require interaction, such as buttons, menu items, or interactive in-game objects.
 * 
 * Implementers of this interface should define the specific behavior that occurs when they are clicked.
 */
public interface ClickListener {

    /**
     * This method is called when a click event occurs on the implementing object.
     * The specific implementation should define the action to be taken, which could range
     * from triggering a game event to navigating a menu or responding to an in-game interaction.
     */
    void onClick();
}
