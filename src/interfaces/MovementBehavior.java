package interfaces;

/**
 * An interface representing movement behavior in the game.
 * This interface defines how an object with movement capabilities should move.
 */
public interface MovementBehavior {

    /**
     * Executes the movement behavior on the given game object.
     * This method defines how the movement behavior is applied to the object, 
     * including factors like speed and direction.
     *
     * @param gameObject The game object to which the movement behavior is applied.
     * @param speed The speed at which the game object should move.
     */
    void execute(Moving gameObject, int speed);
}
