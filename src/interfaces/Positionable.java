package interfaces;

/**
 * An interface representing objects that have a position and size in the game.
 * This interface provides methods to get and set the position and size of the object.
 */
public interface Positionable {

    /**
     * Gets the width of the object.
     *
     * @return The width of the object.
     */
    double getWidth();

    /**
     * Gets the height of the object.
     *
     * @return The height of the object.
     */
    double getHeight();

    /**
     * Gets the X-coordinate of the object's position.
     *
     * @return The X-coordinate of the object.
     */
    int getX();

    /**
     * Gets the Y-coordinate of the object's position.
     *
     * @return The Y-coordinate of the object.
     */
    int getY();

    /**
     * Sets the X-coordinate of the object's position.
     *
     * @param x The new X-coordinate of the object.
     */
    void setX(int x);

    /**
     * Sets the Y-coordinate of the object's position.
     *
     * @param y The new Y-coordinate of the object.
     */
    void setY(int y);
}
