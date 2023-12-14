package ui.interfaces;

/**
 * The interface represents a UI element that can respond to click events.
 * This interface is designed for use in graphical user interfaces, such as in the Space Invaders game,
 * where interactive elements need to respond to user input.
 * Implementing classes should define the specific actions to be performed when the element is clicked.
 */
public interface Clickable {

    /**
     * Invoked when the clickable element is clicked.
     * Implementations of this method should specify the actions to be performed
     * upon the click event, such as triggering a game action, navigating to a different
     * screen, or any other interactive behavior.
     */
    void onClick();
} 
