package interfaces;

/**
 * An interface representing movable game objects in the game.
 * It extends the Positionable interface, adding the capability to move or translate the object in the game space.
 */
public interface Moving extends Positionable {

    /**
     * Translates the position of the object by specified amounts along the X and Y axes.
     * This default method changes the object's position by adding the specified deltas to its current coordinates.
     *
     * @param deltaX The amount to move the object along the X axis.
     * @param deltaY The amount to move the object along the Y axis.
     */
    default void translate(int deltaX, int deltaY){
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }
}
